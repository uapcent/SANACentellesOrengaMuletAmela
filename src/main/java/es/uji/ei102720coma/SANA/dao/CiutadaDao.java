package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Ciutada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CiutadaDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el ciutada a la base de dades */
    public void addCiutada(Ciutada ciutada) {
        jdbcTemplate.update("INSERT INTO Ciutada VALUES(?, ?, ?, ?, ?, ?,?)",
                ciutada.getDniCiutada(),
                ciutada.getNom(),
                ciutada.getCognom(),
                ciutada.getDataNaixement(),
                ciutada.getAdresa(),
                ciutada.getEmail(),
                ciutada.getContrasenya());
    }

    /* Esborra el Ciutada de la base de dades */
    public void deleteCiutada(Ciutada ciutada) {
        jdbcTemplate.update("DELETE FROM Ciutada WHERE dni = '" + ciutada.getDniCiutada() + "'");

    }

    /* Esborra el ciutada a partir de un dni de la base de dades */
    public void deleteCiutadaDni(String dni) {
        jdbcTemplate.update("DELETE FROM Ciutada WHERE dni = '" + dni + "'");
    }

    /* Esborra el ciutada a partir de un email de la base de dades */
    public void deleteCiutadaEmail(String email) {
        jdbcTemplate.update("DELETE FROM Ciutada WHERE email = '" + email + "'");
    }

    /* Actualitza els atributs del ciutada
       (excepte el dni, que és la clau primària) */
    public void updateCiutada(Ciutada ciutada) {
        jdbcTemplate.update("UPDATE Ciutada SET nom = ?, cognom = ?, data_naixement = ? , adreça = ?, email = ?, contrasenya = ? WHERE dni =?",
                ciutada.getNom(),
                ciutada.getCognom(),
                ciutada.getDataNaixement(),
                ciutada.getAdresa(),
                ciutada.getEmail(),
                ciutada.getContrasenya(),
                ciutada.getDniCiutada());
    }

    /* Obté el ciutada amb el dni donat. Torna null si no existeix. */
    public Ciutada getCiutada(String dniCiutada) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Ciutada WHERE dni =?",
                    new CiutadaRowMapper(),
                    dniCiutada);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els ciutadans. Torna una llista buida si no n'hi ha cap. */
    public List<Ciutada> getCiutadans() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Ciutada",
                    new CiutadaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
