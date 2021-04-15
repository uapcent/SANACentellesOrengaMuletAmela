package es.uji.ei102720coma.SANA.controller;


import es.uji.ei102720coma.SANA.dao.EmailDao;
import es.uji.ei102720coma.SANA.model.Email;
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
@RequestMapping("/email")
public class EmailController {

    private EmailDao emailDao;

    @Autowired
    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    @RequestMapping("/list")
    public String listEmails(Model model) {
        model.addAttribute("emails", emailDao.getEmails());
        return "email/list";
    }

    @RequestMapping(value="/add")
    public String addEmail(Model model) {
        model.addAttribute("email", new Email());
        return "email/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("email") Email email, BindingResult bindingResult) {
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
            return "email/add";
        }
        emailDao.addEmail(email);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{email}", method = RequestMethod.GET)
    public String editEmail(Model model, @PathVariable String email) {
        model.addAttribute("email", emailDao.getEmail(email));
        return "email/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("email") Email email, BindingResult bindingResult) {
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
            return "email/update";
        }
        emailDao.updateEmail(email);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{email}")
    public String processDelete(@PathVariable String email) {
        emailDao.deleteEmail(email);
        return "redirect:../list";
    }

}
