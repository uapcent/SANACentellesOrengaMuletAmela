package es.uji.ei102720coma.SANA.dao;


import es.uji.ei102720coma.SANA.model.ControladorEspai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ControladorEspaiDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addControladorEspai(ControladorEspai controladorEspai) {
        jdbcTemplate.update("INSERT INTO Controlador_Espai VALUES(?, ?)",
                controladorEspai.getDniControlador(),
                controladorEspai.getNomEspai());
    }

    public void deleteControladorEspai(String dni, String nom) {
        jdbcTemplate.update("DELETE FROM Controlador_Espai WHERE dni_controlador =? AND nom_espai =?", dni, nom);
    }

    public ControladorEspai getControladorEspai(String dni, String nom) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Controlador_Espai WHERE dni_controlador =? AND nom_espai =?", new ControladorEspaiRowMapper(), dni, nom);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<ControladorEspai> getControladorsEspais() {
        try {
            return jdbcTemplate.query("SELECT * FROM Controlador_Espai", new ControladorEspaiRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
