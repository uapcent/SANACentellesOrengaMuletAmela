package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ControladorEspaiDao;
import es.uji.ei102720coma.SANA.model.ControladorEspai;
import es.uji.ei102720coma.SANA.model.Email;
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
@RequestMapping("/controladorespai")
public class ControladorEspaiController {

    private ControladorEspaiDao controladorEspaiDao;

    @Autowired
    public void setControladorEspaiDao(ControladorEspaiDao controladorEspaiDao) {
        this.controladorEspaiDao = controladorEspaiDao;
    }

    @RequestMapping("/list")
    public String listControladorsEspais(Model model) {
        model.addAttribute("controladorsespais", controladorEspaiDao.getControladorsEspais());
        return "controladorespai/list";
    }

    @RequestMapping(value="/add")
    public String addControladorEspai(Model model) {
        model.addAttribute("controladorespai", new ControladorEspai());
        return "controladorespai/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("controladorespai") ControladorEspai controladorEspai, BindingResult bindingResult) {
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
            return "controladorespai/add";
        }
        controladorEspaiDao.addControladorEspai(controladorEspai);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{dni_controlador}/{nom_espai}", method = RequestMethod.GET)
    public String editControladorEspai(Model model, @PathVariable String dni, @PathVariable String nom) {
        model.addAttribute("controladorespai", controladorEspaiDao.getControladorEspai(dni, nom));
        return "controladorespai/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("controladorespai") ControladorEspai controladorEspai, BindingResult bindingResult) {
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
            return "controladorespai/update";
        }
        controladorEspaiDao.updateControladorEspai(controladorEspai);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dni_controlador}/{nom_espai}")
    public String processDelete(@PathVariable String dni, @PathVariable String nom) {
        controladorEspaiDao.deleteControladorEspai(dni, nom);
        return "redirect:../list";
    }

}