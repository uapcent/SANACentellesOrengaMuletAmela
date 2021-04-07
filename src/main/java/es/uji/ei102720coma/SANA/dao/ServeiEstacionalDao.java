package es.uji.ei102720coma.SANA.dao;


import es.uji.ei102720coma.SANA.model.ServeiEstacional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServeiEstacionalDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addServeiEstacional(ServeiEstacional serveiEstacional) {
        jdbcTemplate.update("INSERT INTO Servei_Estacional VALUES(?, ?, ?, ?)",
                serveiEstacional.getNom(),
                serveiEstacional.getLlocContracte(),
                serveiEstacional.getHoraInici(),
                serveiEstacional.getHoraFi());
    }

    public void deleteServeiEstacional(String nom) {
        jdbcTemplate.update("DELETE FROM Servei_Estacional WHERE nom =?", nom);
    }

    public void deleteServeiEstacional(ServeiEstacional serveiEstacional) {
        jdbcTemplate.update("DELETE FROM Servei_Estacional WHERE nom =?", serveiEstacional.getNom());
    }

    public void updateServeiEstacional(ServeiEstacional serveiEstacional) {
        jdbcTemplate.update("UPDATE Servei_Estacional SET lloc_contracte =?, hora_inici =?, hora_fi =? WHERE nom =?",
                serveiEstacional.getLlocContracte(),
                serveiEstacional.getHoraInici(),
                serveiEstacional.getHoraFi(),
                serveiEstacional.getNom());
    }

    public ServeiEstacional getServeiEstacional(String nom){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Servei_Estacional WHERE nom =?", new ServeiEstacionalRowMapper(), nom);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<ServeiEstacional> getServeisEstacionals() {
        try {
            return jdbcTemplate.query("SELECT * FROM Servei_Estacional", new ServeiEstacionalRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
