package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.model.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("user", new UserDetails());
        return "index";
    }

    @RequestMapping("/panel")
    public String panel(Model model){
        model.addAttribute("user", new UserDetails());
        return "panel";
    }
}
