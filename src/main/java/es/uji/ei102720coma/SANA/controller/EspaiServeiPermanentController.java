package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.EspaiServeiPermanentDao;
import es.uji.ei102720coma.SANA.model.Ciutada;
import es.uji.ei102720coma.SANA.model.EspaiServeiPermanent;
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

@Controller
@RequestMapping("/espaiserveipermanent")
public class EspaiServeiPermanentController {

    private EspaiServeiPermanentDao espaiServeiPermanentDao;

    @Autowired
    public void setEspaiServeiPermanentDao(EspaiServeiPermanentDao espaiServeiPermanentDao) {
        this.espaiServeiPermanentDao = espaiServeiPermanentDao;
    }

    @RequestMapping("/list")
    public String listEspaiServeisPermanents(Model model) {
        model.addAttribute("espaiserveispermanents", espaiServeiPermanentDao.getEspaiServeisPermanents());
        return "espaiserveipermanent/list";
    }

    @RequestMapping(value="/add")
    public String addEspaiServeiPermanent(Model model) {
        model.addAttribute("espaiserveipermanent", new EspaiServeiPermanent());
        return "espaiserveipermanent/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("espaiserveipermanent") EspaiServeiPermanent espaiServeiPermanent, BindingResult bindingResult) {
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
            return "espaiserveipermanent/add";
        }
        espaiServeiPermanentDao.addEspaiServeiPermanent(espaiServeiPermanent);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nom_espai}/{nom_servei_perm}")
    public String processDelete(@PathVariable String nom_espai, @PathVariable String nom_servei_perm) {
        espaiServeiPermanentDao.deleteEspaiServeiPermanent(nom_espai, nom_servei_perm);
        return "redirect:../../list";
    }

}