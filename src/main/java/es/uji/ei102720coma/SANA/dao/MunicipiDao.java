package es.uji.ei102720coma.SANA.dao;


import es.uji.ei102720coma.SANA.model.Municipi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MunicipiDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipi a la base de dades */
    public void addMunicipi(Municipi municipi) {
        jdbcTemplate.update("INSERT INTO Municipi VALUES(?, ?, ?, ?, ?)",
                municipi.getNom(),
                municipi.getLocalitzacioGeografica(),
                municipi.getProvincia(),
                municipi.getCodPostal());
    }

    /* Esborra el municpi de la base de dades */
    public void deleteMunicipi(Municipi municipi) {
        jdbcTemplate.update("DELETE FROM Municipi WHERE nom = '" + municipi.getNom() + "'");

    }

    /* Esborra el municipi a partir de un nom de la base de dades */
    public void deleteMunicipi(String nom) {
        jdbcTemplate.update("DELETE FROM Municipi WHERE nom = '" + nom + "'");
    }

    /* Actualitza els atributs del municipi
       (excepte el nom, que és la clau primària) */
    public void updateMunicipi(Municipi municipi) {
        jdbcTemplate.update("UPDATE Municipi SET localitzacio_geografica = ?, provincia = ?, codi_postal = ? WHERE nom =?",
                municipi.getLocalitzacioGeografica(),
                municipi.getProvincia(),
                municipi.getCodPostal(),
                municipi.getNom());
    }

    /* Obté el municipi amb el nom donat. Torna null si no existeix. */
    public Municipi getMunicipi(String nomMunicipi) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Municipi WHERE nom =?",
                    new MunicipiRowMapper(),
                    nomMunicipi);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<Municipi> getMunicipis() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Municipi",
                    new MunicipiRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }


}
