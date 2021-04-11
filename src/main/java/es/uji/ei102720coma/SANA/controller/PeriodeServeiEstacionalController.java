package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.PeriodeServeiEstacionalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/periodeserveiestacional")
public class PeriodeServeiEstacionalController {

    private PeriodeServeiEstacionalDao periodeServeiEstacionalDao;

    @Autowired
    public void setPeriodeServeiEstacionalDao(PeriodeServeiEstacionalDao periodeServeiEstacionalDao) {
        this.periodeServeiEstacionalDao = periodeServeiEstacionalDao;
    }

    @RequestMapping("/list")
    public String listPeriodeServeisEstacionals(Model model) {
        model.addAttribute("periodeserveisestacionals", periodeServeiEstacionalDao.getPeriodeServeisEstacionals());
        return "periodeserveiestacional/list";
    }
}