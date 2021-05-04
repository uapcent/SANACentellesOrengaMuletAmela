package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ZonaDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix la zona a la base de dades */
    public void addZona(Zona zona) {
        jdbcTemplate.update("INSERT INTO Zona VALUES(?, ?, ?, ?, ?)",
                zona.getNomEspai(),
                zona.getCodi(),
                zona.getLlargaria(),
                zona.getAmplaria(),
                zona.getCapacitatMaxima());
    }

    /* Esborra la zona de la base de dades */
    public void deleteZona(Zona zona) {
        jdbcTemplate.update("DELETE FROM Zona WHERE codi =? AND nom_espai =?", zona.getCodi(), zona.getNomEspai());

    }

    /* Esborra la zona a partir de un codi de la base de dades */
    public void deleteZona(String codi, String nom_espai) {
        jdbcTemplate.update("DELETE FROM Zona WHERE codi =? AND nom_espai =? ", codi, nom_espai);
    }

    /* Actualitza els atributs de la zona
       (excepte el nom, que és la clau primària) */
    public void updateZona(Zona zona) {
        jdbcTemplate.update("UPDATE Zona SET llargaria = ?, amplaria = ?, capacitat_maxima = ? WHERE codi =? AND nom_espai =?",
                zona.getLlargaria(),
                zona.getAmplaria(),
                zona.getCapacitatMaxima(),
                zona.getCodi(),
                zona.getNomEspai());
    }

    /* Obté la zona amb el codi donat. Torna null si no existeix. */
    public Zona getZona(String codiZona, String nom_espai) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Zona WHERE codi =? AND nom_espai =?",
                    new ZonaRowMapper(),
                    codiZona, nom_espai);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots les zones. Torna una llista buida si no n'hi ha cap. */
    public List<Zona> getZones() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Zona",
                    new ZonaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
