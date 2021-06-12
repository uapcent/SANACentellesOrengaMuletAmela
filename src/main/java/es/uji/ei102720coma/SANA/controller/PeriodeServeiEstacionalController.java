package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.PeriodeServeiEstacionalDao;
import es.uji.ei102720coma.SANA.dao.ServeiEstacionalDao;
import es.uji.ei102720coma.SANA.model.EspaiServeiPermanent;
import es.uji.ei102720coma.SANA.model.PeriodeServeiEstacional;
import es.uji.ei102720coma.SANA.model.ServeiEstacional;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/periodeserveiestacional")
public class PeriodeServeiEstacionalController {

    private PeriodeServeiEstacionalDao periodeServeiEstacionalDao;

    @Autowired
    public void setPeriodeServeiEstacionalDao(PeriodeServeiEstacionalDao periodeServeiEstacionalDao) {
        this.periodeServeiEstacionalDao = periodeServeiEstacionalDao;
    }

    @Autowired
    private ServeiEstacionalDao serveiEstacionalDao;

    @RequestMapping("/list")
    public String listPeriodeServeisEstacionals(Model model) {
        model.addAttribute("periodeserveisestacionals", periodeServeiEstacionalDao.getPeriodeServeisEstacionals());
        return "periodeserveiestacional/list";
    }

    @RequestMapping(value="/add/{nom_espai}/{nom_servei}")
    public String addPeriodeServeiEstacional(Model model, @PathVariable String nom_espai, @PathVariable String nom_servei) {
        PeriodeServeiEstacional periodeServeiEstacional = new PeriodeServeiEstacional();
        periodeServeiEstacional.setNomEspai(nom_espai);
        periodeServeiEstacional.setNomServeiEstacional(nom_servei);
        model.addAttribute("periodeserveiestacional", periodeServeiEstacional);
        return "periodeserveiestacional/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("periodeserveiestacional") PeriodeServeiEstacional periodeServeiEstacional, BindingResult bindingResult) {
        PeriodeServeiEstacionalValidator periodeServeiEstacionalValidator = new PeriodeServeiEstacionalValidator();
        periodeServeiEstacionalValidator.validate(periodeServeiEstacional, bindingResult);
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
            return "periodeserveiestacional/add";
        }
        periodeServeiEstacionalDao.addPeriodeServeiEstacional(periodeServeiEstacional);
        return "periodeserveiestacional/anyadircorrecto";
    }

    @RequestMapping(value="/update/{nom_espai}/{nom_servei_estacional}", method = RequestMethod.GET)
    public String editPeriodeServeiEstacional(Model model, @PathVariable String nom_espai, @PathVariable String nom_servei_estacional) {
        model.addAttribute("periodeserveiestacional", periodeServeiEstacionalDao.getPeriodeServeiEstacional(nom_espai, nom_servei_estacional));
        return "periodeserveiestacional/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("periodeserveiestacional") PeriodeServeiEstacional periodeServeiEstacional, BindingResult bindingResult) {
        PeriodeServeiEstacionalValidator periodeServeiEstacionalValidator = new PeriodeServeiEstacionalValidator();
        periodeServeiEstacionalValidator.validate(periodeServeiEstacional, bindingResult);
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
            return "periodeserveiestacional/update";
        }
        periodeServeiEstacionalDao.updateServeiPermanent(periodeServeiEstacional);
        return "periodeserveiestacional/successo";
    }

    @RequestMapping(value="/delete/{nom_espai}/{nom_servei_estacional}")
    public String processDelete(@PathVariable String nom_espai, @PathVariable String nom_servei_estacional) {
        periodeServeiEstacionalDao.deletePeriodeServeiEstacional(nom_espai, nom_servei_estacional);
        return "periodeserveiestacional/successo";
    }

    @RequestMapping(value = {"/listsestespai/{nom_espai}", "/gestionarserveisest/{nom_espai}"})
    public String listServeisEstacionals(Model model, @PathVariable String nom_espai, HttpSession session) {
        List<PeriodeServeiEstacional> listaServeisEstacionals = periodeServeiEstacionalDao.getPeriodeServeisEstacionalsEspai(nom_espai);
        HashMap<ServeiEstacional, PeriodeServeiEstacional> mapaServeisEst = new HashMap<>();
        for(PeriodeServeiEstacional periodeServeiEstacional : listaServeisEstacionals) {
            mapaServeisEst.put(serveiEstacionalDao.getServeiEstacional(periodeServeiEstacional.getNomServeiEstacional()), periodeServeiEstacional);
        }
        model.addAttribute("serveiespai", listaServeisEstacionals);
        model.addAttribute("informacioserveisest", mapaServeisEst);
        model.addAttribute("nom_espai", nom_espai);
        if(session.getAttribute("gestor") != null) {
            return "periodeserveiestacional/gestionarserveisest";
        }
        return "periodeserveiestacional/listsestespai";
    }
}