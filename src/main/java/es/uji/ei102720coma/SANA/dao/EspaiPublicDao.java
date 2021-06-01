package es.uji.ei102720coma.SANA.dao;


import es.uji.ei102720coma.SANA.model.EspaiPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EspaiPublicDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addEspaiPublic(EspaiPublic espaiPublic) {
        jdbcTemplate.update("INSERT INTO Espai_Public VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                espaiPublic.getNom(),
                espaiPublic.getTipusAcces(),
                espaiPublic.getTipusSol(),
                espaiPublic.getTipusEspai(),
                espaiPublic.getLocalitzacioGeografica(),
                espaiPublic.getDescripcio(),
                espaiPublic.getLlargaria(),
                espaiPublic.getAmplaria(),
                espaiPublic.getOrientacio(),
                espaiPublic.getComentaris(),
                espaiPublic.getImatges(),
                espaiPublic.getNomMunicipi());
    }

    public void deleteEspaiPublic(String nom) {
        jdbcTemplate.update("DELETE FROM Espai_Public WHERE nom =?", nom);
    }

    public void deleteEspaiPublic(EspaiPublic espaiPublic) {
        jdbcTemplate.update("DELETE FROM Espai_Public WHERE nom =?", espaiPublic.getNom());
    }

    public void updateEspaiPublic(EspaiPublic espaiPublic) {
        jdbcTemplate.update("UPDATE Espai_Public SET tipus_acces =?, tipus_sol =?, tipus_espai =?, localitzacio_geografica =?, descripcio =?, llargaria =?, amplaria =?, orientacio =?, comentaris =?, imatges =?, nom_municipi =? WHERE nom =?",
                espaiPublic.getTipusAcces(),
                espaiPublic.getTipusSol(),
                espaiPublic.getTipusEspai(),
                espaiPublic.getLocalitzacioGeografica(),
                espaiPublic.getDescripcio(),
                espaiPublic.getLlargaria(),
                espaiPublic.getAmplaria(),
                espaiPublic.getOrientacio(),
                espaiPublic.getComentaris(),
                espaiPublic.getImatges(),
                espaiPublic.getNomMunicipi(),
                espaiPublic.getNom());
    }

    public EspaiPublic getEspaiPublic(String nom) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Espai_Public WHERE nom =?", new EspaiPublicRowMapper(), nom);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<EspaiPublic> getEspaisPublics() {
        try {
            return jdbcTemplate.query("SELECT * FROM Espai_Public", new EspaiPublicRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<EspaiPublic> getEspaisPublicsMunicipi(String nomMunicipi) {
        try {
            return jdbcTemplate.query("SELECT * FROM Espai_Public WHERE nom_municipi =?", new EspaiPublicRowMapper(), nomMunicipi);
        }catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
