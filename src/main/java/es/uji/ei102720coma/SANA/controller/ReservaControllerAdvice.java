package es.uji.ei102720coma.SANA.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ReservaControllerAdvice {

    @ExceptionHandler(value = ReservaException.class)
    public ModelAndView handleReservaException(ReservaException ex){

        ModelAndView mav = new ModelAndView("error/exceptionError");
        mav.addObject("message", ex.getMessage());
        mav.addObject("errorName", ex.getErrorName());
        return mav;
    }
}
