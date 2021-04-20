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

    public void deleteEspaiServeiPermanent(String nom) {
        jdbcTemplate.update("DELETE FROM Espai_Servei_Perm WHERE nom_espai =?", nom);
    }

    public void deleteEspaiServeiPermanent(EspaiServeiPermanent espaiServeiPermanent) {
        jdbcTemplate.update("DELETE FROM Espai_Servei_Perm WHERE nom_espai =?", espaiServeiPermanent.getNomEspai());
    }

    public void updateEspaiServeiPermanent(EspaiServeiPermanent espaiServeiPermanent) {
        jdbcTemplate.update("UPDATE Espai_Servei_Perm SET nom_servei_perm =? WHERE nom_espai =?",
                espaiServeiPermanent.getNomServeiPermanent(),
                espaiServeiPermanent.getNomEspai());
    }

    public EspaiServeiPermanent getEspaiServeiPermanent(String nom) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Espai_Servei_Perm WHERE nom_espai =?", new EspaiServeiPermanentRowMapper(), nom);
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
}