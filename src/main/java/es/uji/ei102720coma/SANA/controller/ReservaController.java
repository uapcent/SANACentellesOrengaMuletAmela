package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.FranjaEspaiDao;
import es.uji.ei102720coma.SANA.dao.ReservaDao;
import es.uji.ei102720coma.SANA.dao.ReservaZonaDao;
import es.uji.ei102720coma.SANA.dao.ZonaDao;
import es.uji.ei102720coma.SANA.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    private ReservaDao reservaDao;
    private static final long numeroReserva = 1;
    @Autowired
    private FranjaEspaiDao franjaEspaiDao;
    @Autowired
    private ZonaDao zonaDao;

    @Autowired
    private ReservaZonaDao reservaZonaDao;

    @Autowired
    public void setReservaDao(ReservaDao reservaDao){ this.reservaDao = reservaDao; }

    @RequestMapping("/list")
    public String listReserves(Model model){
        model.addAttribute("reserves", reservaDao.getReserves());
        return "reserva/list";
    }

    @RequestMapping(value="/add/{nom_espai}/{codi_zona}")
    public String addReserva(Model model, HttpSession session, @PathVariable String nom_espai, @PathVariable String codi_zona) {
        if(session.getAttribute("ciutada") == null) {
            model.addAttribute("user", new UserDetails());
            return "login";
        }
        Reserva reserva = new Reserva();
        ReservaZona reservaZona = new ReservaZona();
        Ciutada ciutada = (Ciutada) session.getAttribute("ciutada");
        FranjaEspai franjaEspai = franjaEspaiDao.getFranjaEspai(nom_espai);
        reserva.setDni(ciutada.getDniCiutada());
        reserva.setNomEspai(nom_espai);
        reserva.setHoraIniciEspai(franjaEspai.getHoraInici());
        reserva.setHoraFiEspai(franjaEspai.getHoraFi());
        reservaZona.setNomZona(codi_zona);
        reservaZona.setNomEspai(nom_espai);
        model.addAttribute("reserva", reserva);
        model.addAttribute("reservazona", reservaZona);
//        model.addAttribute("reserva", new Reserva());
//        model.addAttribute("ciutada", session.getAttribute("ciutada"));
//        model.addAttribute("franjaespai", franjaEspaiDao.getFranjaEspai(nom_espai));
//        model.addAttribute("zona", zonaDao.getZona(nom_espai, codi_zona));
        return "reserva/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva, @ModelAttribute("reservazona") ReservaZona reservaZona,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            for (Object object : bindingResult.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    System.out.println(fieldError.getCode());
                }
                if(object instanceof ObjectError) {
                    ObjectError objectError = (ObjectError) object;
                    System.out.println(objectError.getCode());
                }
            }
            return "reserva/add";
        }
        reserva.setCodi("R0" + numeroReserva+1); //Codigo de la reserva asignado automaticamente.
        reserva.setDataCreacio(LocalDate.now()); //Ponemos como fecha de creación la fecha de ese dia según el pc de esa persona
        reserva.setDataExpiracio(reserva.getDataAsignacio()); //Para la fecha de expiración ponemos que sea igual que la que elige para visitar el espacio.
        reserva.setEstat("Activo"); //Estado asignado automaticamente al reservar.
//      ReservaZona reservaZona = new ReservaZona();
//      reservaZona.setCodiReserva(reserva.getCodi());
//      reservaZona.setNomEspai(reserva.getNomEspai());
        reservaZona.setCodiReserva(reserva.getCodi());
        reservaDao.addReserva(reserva);
        reservaZonaDao.addReservaZona(reservaZona);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{codi}", method = RequestMethod.GET)
    public String editReserva(Model model, @PathVariable String codi) {
        model.addAttribute("reserva", reservaDao.getReserva(codi));
        return "reserva/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("reserva") Reserva reserva, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            for (Object object : bindingResult.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    System.out.println(fieldError.getCode());
                }
                if(object instanceof ObjectError) {
                    ObjectError objectError = (ObjectError) object;
                    System.out.println(objectError.getCode());
                }
            }
            return "reserva/update";
        }
        reservaDao.updateReserva(reserva);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{codi}")
    public String processDelete(@PathVariable String codi) {
        reservaDao.deleteProva(codi);
        return "redirect:../list";
    }

}
