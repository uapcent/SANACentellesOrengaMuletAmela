package es.uji.ei102720coma.SANA.controller;


import es.uji.ei102720coma.SANA.dao.EmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
