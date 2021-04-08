package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ReservaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    private ReservaDao reservaDao;

    @Autowired
    public void setReservaDao(ReservaDao reservaDao){ this.reservaDao = reservaDao; }

    @RequestMapping("/list")
    public String listReserves(Model model){
        model.addAttribute("reserves", reservaDao.getReserves());
        return "reserva/list";
    }
}
