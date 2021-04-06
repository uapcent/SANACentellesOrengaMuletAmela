package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.MunicipiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/municipi")
public class MunicipiController {

    private MunicipiDao municipiDao;

    @Autowired
    public void setMunicipiDao(MunicipiDao municipiDao){ this.municipiDao = municipiDao; }

    // Operacions: Crear, llistar, actualitzar, esborrar

    //Llistar tots els nadadors
    @RequestMapping("/list")
    public String listMunicipis(Model model) {
        model.addAttribute("municipis", municipiDao.getMunicipis());
        return "municipi/list";
    }

}
