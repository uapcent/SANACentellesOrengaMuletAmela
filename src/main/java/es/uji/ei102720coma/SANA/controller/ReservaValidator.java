package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ReservaDao;
import es.uji.ei102720coma.SANA.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class ReservaValidator implements Validator {

    @Autowired
    ReservaDao reservaDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return Reserva.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Reserva reserva = (Reserva) target;
        String dni = reserva.getDni(); //Obtenemos el dni de la persona de la reserva.
        LocalDate hoy = LocalDate.now();
        if(reserva.getDataAsignacio().compareTo(hoy) < 0) {
            errors.rejectValue("dataAsignacio", "Valor incorrecte", "La data ha de ser per a hui o un dia posterior");
        }
    }
}
