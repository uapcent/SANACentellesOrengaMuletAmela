package es.uji.ei102720coma.SANA.controller;


import es.uji.ei102720coma.SANA.dao.ServeiEstacionalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serveiestacional")
public class ServeiEstacionalController {

    private ServeiEstacionalDao serveiEstacionalDao;

    @Autowired
    public void setServeiEstacionalDao(ServeiEstacionalDao serveiEstacionalDao) {
        this.serveiEstacionalDao = serveiEstacionalDao;
    }

    @RequestMapping("/list")
    public String listServeisEstacionals(Model model) {
        model.addAttribute("serveisestacionals", serveiEstacionalDao.getServeisEstacionals());
        return "serveiestacional/list";
    }
}
