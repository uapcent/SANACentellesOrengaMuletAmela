package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ZonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zona")
public class ZonaController {

    private ZonaDao zonaDao;

    @Autowired
    public void setZonaDao(ZonaDao zonaDao){ this.zonaDao = zonaDao; }

    @RequestMapping("/list")
    public String listZones(Model model){
        model.addAttribute("zones", zonaDao.getZones());
        return "zona/list";
    }
}
