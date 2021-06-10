package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.EspaiServeiPermanent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EspaiServeiPermanentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addEspaiServeiPermanent(EspaiServeiPermanent espaiServeiPermanent) {
        jdbcTemplate.update("INSERT INTO Espai_Servei_Perm VALUES(?, ?)",
                espaiServeiPermanent.getNomEspai(),
                espaiServeiPermanent.getNomServeiPermanent());
    }

    public void addEspaiServeiPermanent(String nomEspai, String nomServeiPermanent) {
        jdbcTemplate.update("INSERT INTO Espai_Servei_Perm VALUES(?, ?)",
                nomEspai,
                nomServeiPermanent);
    }

    public void deleteEspaiServeiPermanent(String nom, String nomServei) {
        jdbcTemplate.update("DELETE FROM Espai_Servei_Perm WHERE nom_espai =? AND nom_servei_perm =?", nom, nomServei);
    }

    public void deleteEspaiServeiPermanent(EspaiServeiPermanent espaiServeiPermanent) {
        jdbcTemplate.update("DELETE FROM Espai_Servei_Perm WHERE nom_espai =? AND nom_servei_perm =?", espaiServeiPermanent.getNomEspai(), espaiServeiPermanent.getNomServeiPermanent());
    }

    public EspaiServeiPermanent getEspaiServeiPermanent(String nom, String nomServei) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Espai_Servei_Perm WHERE nom_espai =? AND nom_servei_perm =?", new EspaiServeiPermanentRowMapper(), nom, nomServei);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public List<EspaiServeiPermanent> getEspaiServeisPermanents() {
        try {
            return jdbcTemplate.query("SELECT * FROM Espai_Servei_Perm", new EspaiServeiPermanentRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    public List<EspaiServeiPermanent> getEspaisServeisPermanents(String nomEspai) {
        try {
            return jdbcTemplate.query("SELECT *  FROM Espai_Servei_Perm WHERE nom_espai =?", new EspaiServeiPermanentRowMapper(), nomEspai);
        }catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}