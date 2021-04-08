package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.FranjaEspaiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/franjaEspai")
public class FranjaEspaiController {

    private FranjaEspaiDao franjaEspaiDao;

    @Autowired
    public void setFranjaEspaiDao(FranjaEspaiDao franjaEspaiDao){ this.franjaEspaiDao = franjaEspaiDao; }

    @RequestMapping("/list")
    public String listFranjesEspai(Model model){
        model.addAttribute("franjesEspai", franjaEspaiDao.getFranjes());
        return "franjaEspai/list";
    }
}
