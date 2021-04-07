package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ServeiPermanentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serveipermanent")
public class ServeiPermanentController {

    private ServeiPermanentDao serveiPermanentDao;

    @Autowired
    public void setServeiPermanentDao(ServeiPermanentDao serveiPermanentDao) {
        this.serveiPermanentDao = serveiPermanentDao;
    }

    @RequestMapping("/list")
    public String listServeisPermanents(Model model) {
        model.addAttribute("serveispermanents", serveiPermanentDao.getServeisPermanents());
        return "serveipermanent/list";
    }
}
