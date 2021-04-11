package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.EspaiServeiPermanentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}