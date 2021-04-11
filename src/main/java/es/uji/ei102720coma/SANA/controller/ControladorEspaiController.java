package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ControladorEspaiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}