package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.EspaiServeiPermanentDao;
import es.uji.ei102720coma.SANA.dao.ServeiPermanentDao;
import es.uji.ei102720coma.SANA.model.EspaiServeiPermanent;
import es.uji.ei102720coma.SANA.model.ServeiPermanent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/serveipermanent")
public class ServeiPermanentController {

    private ServeiPermanentDao serveiPermanentDao;

    @Autowired
    public void setServeiPermanentDao(ServeiPermanentDao serveiPermanentDao) {
        this.serveiPermanentDao = serveiPermanentDao;
    }

    @Autowired
    private EspaiServeiPermanentDao espaiServeiPermanentDao;

    @RequestMapping("/list")
    public String listServeisPermanents(Model model) {
        model.addAttribute("serveispermanents", serveiPermanentDao.getServeisPermanents());
        return "serveipermanent/list";
    }

    @RequestMapping(value = "/serveisnoasignatsespai/{nom_espai}")
    public String listServeisNoAsignats(Model model, @PathVariable String nom_espai) {
        List<ServeiPermanent> listaServeisPermanents = serveiPermanentDao.getServeisPermanents(); //Todos los sevicios permanentes disponibles.
        List<EspaiServeiPermanent> listaServeisPermanentsEspai = espaiServeiPermanentDao.getEspaisServeisPermanents(nom_espai); //Todos los servicios que tiene el espacio
        for(int i = 0; i < listaServeisPermanentsEspai.size(); i++) { //Nos quedamos con los servicios que todavía no se hayan asignado a ese espacio.
            EspaiServeiPermanent espaiServeiPermanent = listaServeisPermanentsEspai.get(i);
            for(int j = 0; j < listaServeisPermanents.size(); j++) {
                ServeiPermanent serveiPermanent = listaServeisPermanents.get(j);
                if(serveiPermanent.getNom().equals(espaiServeiPermanent.getNomServeiPermanent())) {
                    listaServeisPermanents.remove(serveiPermanent);
                }
            }
        }
        model.addAttribute("serveisnoasignats", listaServeisPermanents);
        model.addAttribute("nomespai", nom_espai);
        return "serveipermanent/serveisnoasignatsespai";
    }

    @RequestMapping(value="/add")
    public String addServeiPermanent(Model model) {
        model.addAttribute("serveipermanent", new ServeiPermanent());
        return "serveipermanent/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("serveipermanent") ServeiPermanent serveiPermanent, BindingResult bindingResult) {
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
            return "serveipermanent/add";
        }
        serveiPermanentDao.addServeiPermanent(serveiPermanent);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nom}", method = RequestMethod.GET)
    public String editServeiPermanent(Model model, @PathVariable String nom) {
        model.addAttribute("serveipermanent", serveiPermanentDao.getServeiPermanent(nom));
        return "serveipermanent/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("serveipermanent") ServeiPermanent serveiPermanent, BindingResult bindingResult) {
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
            return "serveipermanent/update";
        }
        serveiPermanentDao.updateServeiPermanent(serveiPermanent);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nom}")
    public String processDelete(@PathVariable String nom) {
        serveiPermanentDao.deleteServeiPermanent(nom);
        return "redirect:../list";
    }

}