package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.dao.ReservaDao;
import es.uji.ei102720coma.SANA.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.LocalDate;
import java.util.List;


public class ReservaValidator implements Validator {

    @Autowired
    private ReservaDao reservaDao;

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

        //TODO está roto el DAO

//        List<Reserva> reservas = reservaDao.getReserves();
//        System.out.println(reservas.size());
//        for (Reserva reservaExistente : reservas){
//            if (reservaExistente.getDataAsignacio().compareTo(reserva.getDataAsignacio())==0
//                    && reservaExistente.getEstat().equals("Activo")){
//                errors.rejectValue("dataAsignacio", "Valor incorrecte", "Ja hi ha una reserva per a aquest dia, prova un altre dia o zona");
//            }
//        }

        /*try {
            List<Reserva> reserves = reservaDao.getReserves();
            if (reserves != null) {
                for (int i = 0; i < reserves.size(); i++) {
                    Reserva previa = reserves.get(i);
                    if (previa.getDataAsignacio().compareTo(reserva.getDataAsignacio())==0){
                        errors.rejectValue("dataAsignacio", "Valor incorrecte", "Ja hi ha una reserva en este dia");
                    }
                }
            }
        }catch (NullPointerException ex){
            errors.rejectValue("dataAsignacio", "Valor incorrecte", "Null exception?");
        }*/
    }
}