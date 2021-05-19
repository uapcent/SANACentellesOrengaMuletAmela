package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.GestorMunicipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GestorMunicipalDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addGestorMunicipal(GestorMunicipal gestorMunicipal) {
        jdbcTemplate.update("INSERT INTO Gestor_Municipal VALUES(?,?,?,?,?,?,?,?)",
                gestorMunicipal.getDni(),
                gestorMunicipal.getNom(),
                gestorMunicipal.getCognoms(),
                gestorMunicipal.getNomUsuari(),
                gestorMunicipal.getEmail(),
                gestorMunicipal.getContrasenya(),
                gestorMunicipal.getDataNaixement(),
                gestorMunicipal.getNomMunicipi());
    }

    public void deleteGestorMunicipal(String dni) {
        jdbcTemplate.update("DELETE FROM Gestor_Municipal WHERE dni =?", dni);
    }

    public void deleteGestorMunicipal(GestorMunicipal gestorMunicipal) {
        jdbcTemplate.update("DELETE FROM Gestor_Municipal WHERE dni =?", gestorMunicipal.getDni());
    }

    public void updateGestorMunicipal(GestorMunicipal gestorMunicipal) {
        jdbcTemplate.update("UPDATE Gestor_Municipal SET nom =?, cognoms =?, nom_usuari =?, email =?, contrasenya =?, data_naixement =?, nom_municipi =? WHERE dni =?",
                gestorMunicipal.getNom(),
                gestorMunicipal.getCognoms(),
                gestorMunicipal.getNomUsuari(),
                gestorMunicipal.getEmail(),
                gestorMunicipal.getContrasenya(),
                gestorMunicipal.getDataNaixement(),
                gestorMunicipal.getNomMunicipi(),
                gestorMunicipal.getDni());
    }

    public GestorMunicipal getGestorMunicipal(String dni) {
        try {
            return this.jdbcTemplate.queryForObject("SELECT * FROM Gestor_Municipal WHERE dni =?", new GestorMunicipalRowMapper(), dni);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public GestorMunicipal getGestorMunicipalEmail(String email) {
        try {
            return this.jdbcTemplate.queryForObject("SELECT * FROM Gestor_Municipal WHERE email =? ", new GestorMunicipalRowMapper(), email);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<GestorMunicipal> getGestorsMunicipals() {
        try {
            return jdbcTemplate.query("SELECT * FROM Gestor_Municipal", new GestorMunicipalRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}
