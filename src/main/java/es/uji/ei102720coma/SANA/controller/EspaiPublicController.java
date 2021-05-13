package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.EspaiPublicDao;
import es.uji.ei102720coma.SANA.model.EspaiPublic;
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
@RequestMapping("/espaipublic")
public class EspaiPublicController {

    private EspaiPublicDao espaiPublicDao;

    @Autowired
    public void setEspaiPublicDao(EspaiPublicDao espaiPublicDao) {
        this.espaiPublicDao = espaiPublicDao;
    }

    @RequestMapping("/list")
    public String listEspaisPublics(Model model) {
        model.addAttribute("espaispublics", espaiPublicDao.getEspaisPublics());
        return "espaipublic/list";
    }

    @RequestMapping(value="/add")
    public String addEspaiPublic(Model model) {
        model.addAttribute("espaipublic", new EspaiPublic());
        return "espaipublic/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("espaipublic") EspaiPublic espaiPublic, BindingResult bindingResult) {
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
            return "espaipublic/add";
        }
        espaiPublicDao.addEspaiPublic(espaiPublic);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nom}", method = RequestMethod.GET)
    public String editEspaiPublic(Model model, @PathVariable String nom) {
        model.addAttribute("espaipublic", espaiPublicDao.getEspaiPublic(nom));
        return "espaipublic/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("espaipublic") EspaiPublic espaiPublic, BindingResult bindingResult) {
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
            return "espaipublic/update";
        }
        espaiPublicDao.updateEspaiPublic(espaiPublic);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nom}")
    public String processDelete(@PathVariable String nom) {
        espaiPublicDao.deleteEspaiPublic(nom);
        return "redirect:../list";
    }

    @RequestMapping(value = "/informacio/{nom}")
    public String informacioEspaiPublic(Model model, @PathVariable String nom) {
        model.addAttribute("espaipublic", espaiPublicDao.getEspaiPublic(nom));
        return "espaipublic/informacio";
    }

}
