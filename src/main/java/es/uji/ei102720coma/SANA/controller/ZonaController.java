package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ZonaDao;
import es.uji.ei102720coma.SANA.model.Zona;
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

@Controller
@RequestMapping("/zona")
public class ZonaController {

    private ZonaDao zonaDao;

    @Autowired
    public void setZonaDao(ZonaDao zonaDao){ this.zonaDao = zonaDao; }

    @RequestMapping("/list")
    public String listZones(Model model){
        model.addAttribute("zones", zonaDao.getZones());
        return "zona/list";
    }

    @RequestMapping(value="/add")
    public String addZona(Model model) {
        model.addAttribute("zona", new Zona());
        return "zona/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("zona") Zona zona, BindingResult bindingResult) {
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
            return "zona/add";
        }
        zonaDao.addZona(zona);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nom_espai}/{codi}", method = RequestMethod.GET)
    public String editCiutada(Model model, @PathVariable String nom_espai, @PathVariable String codi) {
        model.addAttribute("zona", zonaDao.getZona(codi, nom_espai));
        return "zona/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("zona") Zona zona, BindingResult bindingResult) {
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
            return "zona/update";
        }
        zonaDao.updateZona(zona);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nom_espai}/{codi}")
    public String processDelete(@PathVariable String nom_espai, @PathVariable String codi) {
        zonaDao.deleteZona(codi, nom_espai);
        return "redirect:../../list";
    }

    @RequestMapping(value = "/listzonesespai/{nom_espai}")
    public String listZonasEspacio(Model model, @PathVariable String nom_espai) {
        model.addAttribute("zonasespacio", zonaDao.getZonesEspai(nom_espai));
        model.addAttribute("nomespaipublic", nom_espai);
        return "zona/listzonesespai";

    }


}
