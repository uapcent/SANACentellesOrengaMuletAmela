package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.GestorMunicipalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gestormunicipal")
public class GestorMunicipalController {

    private GestorMunicipalDao gestorMunicipalDao;


    @Autowired
    public void setGestorMunicipalDao(GestorMunicipalDao gestorMunicipalDao) {
        this.gestorMunicipalDao = gestorMunicipalDao;
    }

    @RequestMapping("/list")
    public String listGestorsMunicipals(Model model) {
        model.addAttribute("gestorsmunicipals", gestorMunicipalDao.getGestorsMunicipals());
        return "gestormunicipal/list";
    }
}
