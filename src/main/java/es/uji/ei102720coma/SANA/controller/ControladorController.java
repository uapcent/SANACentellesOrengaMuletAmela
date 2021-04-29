package es.uji.ei102720coma.SANA.controller;


import es.uji.ei102720coma.SANA.dao.ControladorDao;
import es.uji.ei102720coma.SANA.model.Controlador;
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
@RequestMapping("/controlador")
public class ControladorController {

    private ControladorDao controladorDao;

    @Autowired
    public void setControladorDao(ControladorDao controladorDao) {
        this.controladorDao = controladorDao;
    }

    @RequestMapping("/list")
    public String listControladors(Model model) {
        model.addAttribute("controladors", controladorDao.getControladors());
        return "controlador/list";
    }

    @RequestMapping(value="/add")
    public String addControlador(Model model) {
        model.addAttribute("controlador", new Controlador());
        return "controlador/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("controlador") Controlador controlador, BindingResult bindingResult) {
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
            return "controlador/add";
        }
        controladorDao.addControlador(controlador);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{dni}", method = RequestMethod.GET)
    public String editControlador(Model model, @PathVariable String dni) {
        model.addAttribute("controlador", controladorDao.getControlador(dni));
        return "controlador/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("controlador") Controlador controlador, BindingResult bindingResult) {
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
            return "controlador/update";
        }
        controladorDao.updateControlador(controlador);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dni}")
    public String processDelete(@PathVariable String dni) {
        controladorDao.deleteControlador(dni);
        return "redirect:../list";
    }

}
