package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.PeriodeServeiEstacional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeriodeServeiEstacionalDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addPeriodeServeiEstacional(PeriodeServeiEstacional periodeServeiEstacional) {
        jdbcTemplate.update("INSERT INTO Periode_Servei_Estacional VALUES(?, ?, ?, ?)",
                periodeServeiEstacional.getNomEspai(),
                periodeServeiEstacional.getNomServeiEstacional(),
                periodeServeiEstacional.getDataInici(),
                periodeServeiEstacional.getDataFi());
    }

    public void deletePeriodeServeiEstacional(String nom) {
        jdbcTemplate.update("DELETE FROM Periode_Servei_Estacional WHERE nom_espai =?", nom);
    }

    public void deletePeriodeServeiEstacional(PeriodeServeiEstacional periodeServeiEstacional) {
        jdbcTemplate.update("DELETE FROM Periode_Servei_Estacional WHERE nom_espai =?", periodeServeiEstacional.getNomEspai());
    }

    public void updateServeiPermanent(PeriodeServeiEstacional serveiPermanent) {
        jdbcTemplate.update("UPDATE Periode_Servei_Estacional SET nom_servei_estacional =?, data_inici =?, data_fi =? WHERE nom_espai =?",
                serveiPermanent.getNomServeiEstacional(),
                serveiPermanent.getDataInici(),
                serveiPermanent.getDataFi(),
                serveiPermanent.getNomEspai());
    }

    public PeriodeServeiEstacional getPeriodeServeiEstacional(String nom) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Periode_Servei_Estacional WHERE nom_espai =?", new PeriodeServeiEstacionalRowMapper(), nom);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public List<PeriodeServeiEstacional> getPeriodeServeisEstacionals() {
        try {
            return jdbcTemplate.query("SELECT * FROM Periode_Servei_Estacional", new PeriodeServeiEstacionalRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}