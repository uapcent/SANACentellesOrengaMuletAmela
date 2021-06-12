package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.model.PeriodeServeiEstacional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class PeriodeServeiEstacionalValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PeriodeServeiEstacional.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PeriodeServeiEstacional periodeServeiEstacional = (PeriodeServeiEstacional) target;

        //Validacion
        LocalDate hoy = LocalDate.now();

        if(periodeServeiEstacional.getDataInici().compareTo(hoy) < 0) {
            errors.rejectValue("dataInici", "obligatorio", "ERROR: La fecha de inicio debe ser igual o posterior al dia de hoy");
        }

        if(periodeServeiEstacional.getDataFi().compareTo(hoy) < 0) {
            errors.rejectValue("dataFi", "obligatorio", "ERROR: La fecha de fin debe ser igual o posterior al dia de hoy");
        }

    }
}
