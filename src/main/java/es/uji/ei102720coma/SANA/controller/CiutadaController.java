package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.CiutadaDao;
import es.uji.ei102720coma.SANA.model.Ciutada;
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
@RequestMapping("/ciutada")
public class CiutadaController {

    private CiutadaDao ciutadaDao;

    @Autowired
    public void setCiutadaDao(CiutadaDao ciutadaDao){ this.ciutadaDao = ciutadaDao; }

    @RequestMapping("/list")
    public String listCiutadans(Model model){
        model.addAttribute("ciutadans", ciutadaDao.getCiutadans());
        return "ciutada/list";
    }

    @RequestMapping(value="/add")
    public String addCiutada(Model model) {
        model.addAttribute("ciutada", new Ciutada());
        return "ciutada/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("ciutada") Ciutada ciutada, BindingResult bindingResult) {
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
            return "ciutada/add";
        }
        ciutadaDao.addCiutada(ciutada);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{dni}", method = RequestMethod.GET)
    public String editCiutada(Model model, @PathVariable String dni) {
        model.addAttribute("ciutada", ciutadaDao.getCiutada(dni));
        return "ciutada/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("ciutada") Ciutada ciutada, BindingResult bindingResult) {
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
            return "ciutada/update";
        }
        ciutadaDao.updateCiutada(ciutada);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dni}")
    public String processDelete(@PathVariable String dni) {
        ciutadaDao.deleteCiutadaDni(dni);
        return "redirect:../list";
    }

}