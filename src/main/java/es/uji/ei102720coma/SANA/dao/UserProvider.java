package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Ciutada;
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
        Ciutada ciutada = ciutadaDao.getCiutadaEmail(email);
        UserDetails user = new UserDetails();
        if (ciutada == null)
            return null; // Usuari no trobat
        // Contrasenya
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        if (passwordEncryptor.checkPassword(password, user.getPassword())) {
            // Es deuria esborrar de manera segura el camp password abans de tornar-lo
            return user;
        }
        else {
            return null; // bad login!
        }
    }

    @Override
    public Collection<UserDetails> listAllUsers() {
        return knownUsers.values();
    }
}
