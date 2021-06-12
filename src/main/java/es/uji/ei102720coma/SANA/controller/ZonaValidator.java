package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.model.Zona;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ZonaValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Zona.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Zona zona = (Zona) target;

        //Validacion
        if(zona.getCodi().trim().equals("")) {
            errors.rejectValue("codi", "obligatorio", "ERROR: Tienes que añadir un codigo que no sea vacío");
        }

        if(zona.getLlargaria() == 0.0) {
            errors.rejectValue("llargaria", "obligatorio", "ERROR: La longitud debe ser mayor que 0");
        }

        if(zona.getAmplaria() == 0.0) {
            errors.rejectValue("amplaria", "obligatorio", "ERROR: La anchura debe ser mayor que 0");
        }

        if(zona.getCapacitatMaxima() == 0) {
            errors.rejectValue("capacitatMaxima", "obligatorio", "ERROR: La capacidad maxima debe ser mayor que 0");
        }

    }
}
