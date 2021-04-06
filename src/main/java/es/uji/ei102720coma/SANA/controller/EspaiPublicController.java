package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.EspaiPublicDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("espaipublic")
public class EspaiPublicController {

    private EspaiPublicDao espaiPublicDao;

    public void setEspaiPublicDao(EspaiPublicDao espaiPublicDao) {
        this.espaiPublicDao = espaiPublicDao;
    }

    @RequestMapping("/list")
    public String listEspaisPublics(Model model) {
        model.addAttribute("espaispublics", espaiPublicDao.getEspaisPublics());
        return "espaispublics/list";
    }
}
