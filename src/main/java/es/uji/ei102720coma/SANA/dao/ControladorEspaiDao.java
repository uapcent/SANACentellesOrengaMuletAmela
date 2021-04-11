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
        jdbcTemplate.update("INSERTO INTO Controlador_Espai VALUES(?, ?)",
                controladorEspai.getDniControlador(),
                controladorEspai.getNomEspai());
    }

    public void deleteControladorEspai(String dni) {
        jdbcTemplate.update("DELETE FROM Controlador_Espai WHERE dni_controlador =?", dni);
    }

    public void deleteControladorEspai(ControladorEspai controladorEspai) {
        jdbcTemplate.update("DELETE FROM Controlador_Espai WHERE dni_controlador =?", controladorEspai.getDniControlador());
    }

    public void updateControladorEspai(ControladorEspai controladorEspai) {
        jdbcTemplate.update("UPDATE Controlador_Espai SET nom_espai =? WHERE dni_controlador =?",
                controladorEspai.getNomEspai(),
                controladorEspai.getDniControlador());
    }

    public ControladorEspai getControladorEspai(String dni) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Controlador_Espai WHERE dni_controlador =?", new ControladorEspaiRowMapper(), dni);
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
