package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ReservaZonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservazona")
public class ReservaZonaController {

    private ReservaZonaDao reservaZonaDao;

    @Autowired
    public void setReservaZonaDao(ReservaZonaDao reservaZonaDao) {
        this.reservaZonaDao = reservaZonaDao;
    }

    @RequestMapping("/list")
    public String listReservasZonas(Model model) {
        model.addAttribute("reservaszonas", reservaZonaDao.getReservasZonas());
        return "reservazona/list";
    }
}