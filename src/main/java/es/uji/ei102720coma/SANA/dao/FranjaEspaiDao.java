package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.FranjaEspai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FranjaEspaiDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){ jdbcTemplate = new JdbcTemplate(dataSource);}

    /*Afegir franjaEspai a la base de dades*/
    public void addFranja(FranjaEspai franjaEspai){
        jdbcTemplate.update("INSERT INTO Franja_Espai VALUES(?, ?, ?)",
                franjaEspai.getNom_espai(),
                franjaEspai.getHora_inici(),
                franjaEspai.getHora_fi());
    }

    /* Esborra la franja_espai de la base de dades */
    public void deleteFranjaEspai(FranjaEspai franjaEspai) {
        jdbcTemplate.update("DELETE FROM Franja_Espai WHERE nom = '" + franjaEspai.getNom_espai() + "'");

    }

    /* Actualitza els atributs de la franja_espai
       (excepte el nom, que és la clau primària) */
    public void updateFranjaEspai(FranjaEspai franjaEspai) {
        jdbcTemplate.update("UPDATE Franja_Espai SET hora_inici = ?, hora_fi = ? WHERE nom_espai =?",
                franjaEspai.getHora_inici(),
                franjaEspai.getHora_fi(),
                franjaEspai.getNom_espai());
    }

    /* Obté la franja amb el nom donat. Torna null si no existeix. */
    public FranjaEspai getFranjaEspai(String nomEspai) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Franja_Espai WHERE nom_espai =?",
                    new FranjaEspaiRowMapper(),
                    nomEspai);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté totes les franjes. Torna una llista buida si no n'hi ha cap. */
    public List<FranjaEspai> getFranjes() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Franja_Espai",
                    new FranjaEspaiRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

}
