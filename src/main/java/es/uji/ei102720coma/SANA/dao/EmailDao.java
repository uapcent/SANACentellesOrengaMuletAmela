package es.uji.ei102720coma.SANA.dao;


import es.uji.ei102720coma.SANA.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailDao {

    private JdbcTemplate jdbcTemplate;

    //Obte el jdbcTemplate a partir del DataSource
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el email a la base de dades */
    public void addEmail(Email email) {
        jdbcTemplate.update("INSERT INTO Email VALUES(?, ?)", email.getEmail(), email.getContrasenya());
    }

    /* Esborra el email de la base de dades */
    public void deleteEmail(Email email) {
        jdbcTemplate.update("DELETE FROM Email WHERE email =?", email.getEmail());

    }

    /* Esborra el email a partir de un nom de la base de dades */
    public void deleteEmail(String email) {
        jdbcTemplate.update("DELETE FROM Email WHERE email =?", email);
    }

    /* Actualitza els atributs del email
       (excepte el email, que és la clau primària) */
    public void updateEmail(Email email) {
        jdbcTemplate.update("UPDATE Email SET contrasenya =? WHERE email =?", email.getContrasenya(), email.getEmail());
    }

    /* Obté el email amb el nom email. Torna null si no existeix. */
    public Email getEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Email WHERE email =?", new EmailRowMapper(), email);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<Email> getEmails() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Email", new EmailRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

}
