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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    //Llista de les reserves de un ciutadà
    @RequestMapping(value = "/listreservesciutada")
    public String listReservesCiutada(Model model, HttpSession session){
        Ciutada ciutada = (Ciutada) session.getAttribute("ciutada");
        String dni_ciutada = ciutada.getDniCiutada();
        List<Reserva> listReservesCiudada = reservaDao.getReserves(dni_ciutada);
        HashMap<Reserva, ReservaZona> reservaZonaHashMap = new HashMap<>();
        for (Reserva reserva : listReservesCiudada){
            ReservaZona zona = reservaZonaDao.getReservaZona(reserva.getCodi());
            reservaZonaHashMap.put(reserva, zona);
            //System.out.println(zona.getNomZona());
        }
        model.addAttribute("reservaZonaHashMap", reservaZonaHashMap);
        model.addAttribute("llistaReserves", listReservesCiudada);
        model.addAttribute("dniCiutada", dni_ciutada);
        return "reserva/listreservesciutada";
    }

    @RequestMapping(value="/add/{nom_espai}/{codi_zona}")
    public String addReserva(Model model, HttpSession session, @PathVariable String nom_espai, @PathVariable String codi_zona) {
        if(session.getAttribute("ciutada") == null) {
            model.addAttribute("user", new UserDetails());
            session.setAttribute("nextUrl", "reserva/add/" + nom_espai + "/" + codi_zona);
            return "login";
        }
        Reserva reserva = new Reserva();
        ReservaZona reservaZona = new ReservaZona();
        FranjaEspai franjaEspai = franjaEspaiDao.getFranjaEspai(nom_espai);
        Ciutada ciutada = (Ciutada) session.getAttribute("ciutada");
        Zona zona = zonaDao.getZona(codi_zona, nom_espai);
        ArrayList<Integer> cantidadList = new ArrayList<>();
        reserva.setDni(ciutada.getDniCiutada());
        reserva.setNomEspai(nom_espai);
        reserva.setHoraIniciEspai(franjaEspai.getHoraInici());
        reserva.setHoraFiEspai(franjaEspai.getHoraFi());
        reservaZona.setNomZona(codi_zona);
        reservaZona.setNomEspai(nom_espai);
        for(int i = 1; i <= zona.getCapacitatMaxima(); i++) {
            cantidadList.add(i);
        }
        model.addAttribute("reserva", reserva);
        model.addAttribute("reservazona", reservaZona);
        //model.addAttribute("codi_zona", codi_zona);
        session.setAttribute("codi_zona", codi_zona);
        session.setAttribute("cantidadList", cantidadList);
        return "reserva/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva, HttpSession session,BindingResult bindingResult) {
        ReservaValidator reservaValidator = new ReservaValidator();
        reservaValidator.validate(reserva, bindingResult);
        if (bindingResult.hasErrors()){
//          for (Object object : bindingResult.getAllErrors()) {
//              if(object instanceof FieldError) {
//                  FieldError fieldError = (FieldError) object;
//                  System.out.println(fieldError.getCode());
//               }
//               if(object instanceof ObjectError) {
//                  ObjectError objectError = (ObjectError) object;
//                  System.out.println(objectError.getCode());
//               }
//          }
            return "reserva/add";
        }
        List<Reserva> reservas = reservaDao.getReserves(); //Obtenemos todas las reservas hasta la fecha.

        //Comprova que no hi hajen reserves en eixe dia


        Reserva ultimaReserva = reservas.get(reservas.size()-1);
        String codigoUltimaReserva = ultimaReserva.getCodi();
        String [] ultimoNumeroReserva = codigoUltimaReserva.split("R0"); //Sacamos la parte del numero de la reserva
        int numeroActualReserva = Integer.valueOf(ultimoNumeroReserva[1]) + 1;
        reserva.setCodi("R0" + numeroActualReserva); //Codigo de la reserva asignado automaticamente.
        reserva.setDataCreacio(LocalDate.now()); //Ponemos como fecha de creación la fecha de ese dia según el pc de esa persona
        reserva.setDataExpiracio(reserva.getDataAsignacio()); //Para la fecha de expiración ponemos que sea igual que la que elige para visitar el espacio.
        reserva.setEstat("Activo"); //Estado asignado automaticamente al reservar.
        ReservaZona reservaZona = new ReservaZona();
        reservaZona.setCodiReserva(reserva.getCodi());
        reservaZona.setNomEspai(reserva.getNomEspai());
        String codigoZona = (String) session.getAttribute("codi_zona");
        reservaZona.setNomZona(codigoZona);
        reservaDao.addReserva(reserva);
        reservaZonaDao.addReservaZona(reservaZona);
        return "reserva/correcto";
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
        //reservaZonaDao.deleteReservaZona(codi);
        reservaDao.cancelReserva(codi);
        return "redirect:../list";
    }

}
