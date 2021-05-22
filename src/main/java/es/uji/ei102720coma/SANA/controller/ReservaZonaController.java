package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ReservaZonaDao;
import es.uji.ei102720coma.SANA.model.ReservaZona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value="/add")
    public String addReservaZona(Model model) {
        model.addAttribute("reservazona", new ReservaZona());
        return "reservazona/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("reservazona") ReservaZona reservaZona, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            for (Object object : bindingResult.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;

                    System.out.println(fieldError.getCode());
                }

                if(object instanceof ObjectError) {
                    ObjectError objectError = (ObjectError) object;

                    System.out.println(objectError.getCode());
                }
            }
            return "reservazona/add";
        }
        reservaZonaDao.addReservaZona(reservaZona);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{codi}")
    public String processDelete(@PathVariable String codi) {
        reservaZonaDao.deleteReservaZona(codi);
        return "redirect:../list";
    }
}