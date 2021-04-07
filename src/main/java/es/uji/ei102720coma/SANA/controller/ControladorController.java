package es.uji.ei102720coma.SANA.controller;


import es.uji.ei102720coma.SANA.dao.ControladorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
