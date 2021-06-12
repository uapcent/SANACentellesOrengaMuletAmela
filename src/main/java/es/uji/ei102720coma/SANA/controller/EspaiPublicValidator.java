package es.uji.ei102720coma.SANA.controller;

import es.uji.ei102720coma.SANA.model.EspaiPublic;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EspaiPublicValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return EspaiPublic.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EspaiPublic espaiPublic = (EspaiPublic) target;
        //Validacion
        if(espaiPublic.getNom().trim().equals("")) {
            errors.rejectValue("nom", "obligatorio", "ERROR: Tienes que introducir un nombre");
        }

        if(espaiPublic.getTipusAcces().equals("No seleccionat")) {
            errors.rejectValue("tipusAcces", "obligatorio", "ERROR: No has seleccionado ningun tipo de acceso");
        }

        if(espaiPublic.getTipusSol().equals("No seleccionat")) {
            errors.rejectValue("tipusSol", "obligatorio", "ERROR: No has seleccionado ningun terreno");
        }

        if(espaiPublic.getTipusEspai().equals("No seleccionat")) {
            errors.rejectValue("tipusEspai", "obligatorio", "ERROR: No has seleccionado el tipo de espacio");
        }

        if(espaiPublic.getLocalitzacioGeografica().trim().equals("")) {
            errors.rejectValue("localitzacioGeografica", "obligatori", "ERROR: Tienes que introducir una localización geográfica");
        }

        if(espaiPublic.getDescripcio().trim().equals("")) {
            errors.rejectValue("descripcio", "obligatori", "ERROR: Tienes que añadir una descripcion al espacio");
        }

        if(espaiPublic.getLlargaria() == 0.0) {
            errors.rejectValue("llargaria", "obligatorio", "ERROR: Tienes que añadir un numero mayor que 0");
        }

        if((espaiPublic.getAmplaria() == 0.0)){
            errors.rejectValue("amplaria", "obligatorio", "ERROR: Tienes que añadir un numero mayor que 0");
        }

        if(espaiPublic.getOrientacio().trim().equals("")) {
            errors.rejectValue("orientacio", "obligatorio", "ERROR: Tienes que añadir una orientacion al espacio");
        }
    }
}
