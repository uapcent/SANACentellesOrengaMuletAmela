package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.CiutadaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ciutada")
public class CiutadaController {

    private CiutadaDao ciutadaDao;

    @Autowired
    public void setCiutadaDao(CiutadaDao ciutadaDao){ this.ciutadaDao = ciutadaDao; }

    @RequestMapping("/list")
    public String listCiutadans(Model model){
        model.addAttribute("ciutadans", ciutadaDao.getCiutadans());
        return "ciutada/list";
    }
}
