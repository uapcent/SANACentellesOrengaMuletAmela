package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.FranjaEspaiDao;
import es.uji.ei102720coma.SANA.model.ControladorEspai;
import es.uji.ei102720coma.SANA.model.FranjaEspai;
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
@RequestMapping("/franjaEspai")
public class FranjaEspaiController {

    private FranjaEspaiDao franjaEspaiDao;

    @Autowired
    public void setFranjaEspaiDao(FranjaEspaiDao franjaEspaiDao){ this.franjaEspaiDao = franjaEspaiDao; }

    @RequestMapping("/list")
    public String listFranjesEspai(Model model){
        model.addAttribute("franjesEspai", franjaEspaiDao.getFranjes());
        return "franjaEspai/list";
    }

    @RequestMapping(value="/add")
    public String addFranjaEspai(Model model) {
        model.addAttribute("franjaEspai", new FranjaEspai());
        return "franjaEspai/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("franjaEspai") FranjaEspai franjaEspai, BindingResult bindingResult) {
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
            return "franjaEspai/add";
        }
        franjaEspaiDao.addFranja(franjaEspai);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nom_espai}", method = RequestMethod.GET)
    public String editFranjaEspai(Model model, @PathVariable String nom_espai) {
        model.addAttribute("franjaEspai", franjaEspaiDao.getFranjaEspai(nom_espai));
        return "franjaEspai/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("franjaEspai") FranjaEspai franjaEspai, BindingResult bindingResult) {
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
            return "franjaEspai/update";
        }
        franjaEspaiDao.updateFranjaEspai(franjaEspai);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nom_espai}")
    public String processDelete(@PathVariable String nom_espai) {
        franjaEspaiDao.deleteFranjaEspai(nom_espai);
        return "redirect:../list";
    }

}
