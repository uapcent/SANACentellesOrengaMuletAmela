package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Ciutada;
import es.uji.ei102720coma.SANA.model.GestorMunicipal;
import es.uji.ei102720coma.SANA.model.UserDetails;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserProvider implements UserDao {

    private CiutadaDao ciutadaDao;
    private GestorMunicipalDao gestorMunicipalDao;

    @Autowired
    public void setGestorMunicipalDao(GestorMunicipalDao gestorMunicipalDao) {
        this.gestorMunicipalDao = gestorMunicipalDao;
    }

    @Autowired
    public void setCiutadaDao(CiutadaDao ciutadaDao){ this.ciutadaDao = ciutadaDao; }

    @Override
    public UserDetails loadUserByUsername(String email, String password) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        Ciutada ciutada = ciutadaDao.getCiutadaEmail(email); //Mirem si la base de dades conté al usuari en la taula ciutada
        UserDetails user = new UserDetails();
        if (ciutada != null) {
            user.setEmail(ciutada.getEmail());
            user.setPassword(passwordEncryptor.encryptPassword(ciutada.getContrasenya()));
            if(passwordEncryptor.checkPassword(password, user.getPassword())) {
                return user;
            } else {
                return null; //bad login!
            }
        }else { // Si no es troba en la taula ciutada, mirem si es gestor municipal.
            GestorMunicipal gestorMunicipal = gestorMunicipalDao.getGestorMunicipalEmail(email);
            if(gestorMunicipal != null) {
                user.setEmail(gestorMunicipal.getEmail());
                user.setPassword(passwordEncryptor.encryptPassword(gestorMunicipal.getContrasenya()));
                if (passwordEncryptor.checkPassword(password, user.getPassword())) {
                    return user;
                } else {
                    return null; // bad login
                }
            }else { //Si tampoc es gestorMunicipal, es que aquest usuari no existeix.
                return null; //Usuari no trobat
            }
        }
    }
    @Override
    public Collection<UserDetails> listAllUsers() {
        return null;
    }
}
