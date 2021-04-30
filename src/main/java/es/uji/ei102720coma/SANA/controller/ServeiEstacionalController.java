package es.uji.ei102720coma.SANA.controller;


import es.uji.ei102720coma.SANA.dao.ServeiEstacionalDao;
import es.uji.ei102720coma.SANA.model.ServeiEstacional;
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
@RequestMapping("/serveiestacional")
public class ServeiEstacionalController {

    private ServeiEstacionalDao serveiEstacionalDao;

    @Autowired
    public void setServeiEstacionalDao(ServeiEstacionalDao serveiEstacionalDao) {
        this.serveiEstacionalDao = serveiEstacionalDao;
    }

    @RequestMapping("/list")
    public String listServeisEstacionals(Model model) {
        model.addAttribute("serveisestacionals", serveiEstacionalDao.getServeisEstacionals());
        return "serveiestacional/list";
    }

    @RequestMapping(value="/add")
    public String addServeiEstacional(Model model) {
        model.addAttribute("serveiestacional", new ServeiEstacional());
        return "serveiestacional/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("serveiestacional") ServeiEstacional serveiEstacional, BindingResult bindingResult) {
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
            return "serveiestacional/add";
        }
        serveiEstacionalDao.addServeiEstacional(serveiEstacional);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nom}", method = RequestMethod.GET)
    public String editServeiEstacional(Model model, @PathVariable String nom) {
        model.addAttribute("serveiestacional", serveiEstacionalDao.getServeiEstacional(nom));
        return "serveiestacional/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("serveiestacional") ServeiEstacional serveiEstacional, BindingResult bindingResult) {
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
            return "serveiestacional/update";
        }
        serveiEstacionalDao.updateServeiEstacional(serveiEstacional);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nom}")
    public String processDelete(@PathVariable String nom) {
        serveiEstacionalDao.deleteServeiEstacional(nom);
        return "redirect:../list";
    }

}
