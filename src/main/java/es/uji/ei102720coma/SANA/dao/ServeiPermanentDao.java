package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.ServeiPermanent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ServeiPermanentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addServeiPermanent(ServeiPermanent serveiPermanent) {
        jdbcTemplate.update("INSERT INTO Servei_Permanent VALUES(?, ?, ?, ?, ?, ?)",
                serveiPermanent.getNom(),
                serveiPermanent.getLlocContracte(),
                serveiPermanent.getHoraInici(),
                serveiPermanent.getHoraFi(),
                serveiPermanent.getDataInici(),
                serveiPermanent.getDataFi());
    }

    public void deleteServeiPermanent(String nom) {
        jdbcTemplate.update("DELETE FROM Servei_Permanent WHERE nom =?", nom);
    }

    public void deleteServeiPermanent(ServeiPermanent serveiPermanent) {
        jdbcTemplate.update("DELETE FROM Servei_Permanent WHERE nom =?", serveiPermanent.getNom());
    }

    public void updateServeiPermanent(ServeiPermanent serveiPermanent) {
        jdbcTemplate.update("UPDATE Servei_Permanent SET lloc_contracte =?, hora_inici =?, hora_fi =?, data_inici =?, data_fi =? WHERE nom =?",
                serveiPermanent.getLlocContracte(),
                serveiPermanent.getHoraInici(),
                serveiPermanent.getHoraFi(),
                serveiPermanent.getDataInici(),
                serveiPermanent.getDataFi());
    }

    public ServeiPermanent getServeiPermanent(String nom) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Servei_Permanent WHERE nom =?", new ServeiPermanentRowMapper(), nom);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public List<ServeiPermanent> getServeisPermanents() {
        try {
            return jdbcTemplate.query("SELECT * FROM Servei_Permanent", new ServeiPermanentRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
