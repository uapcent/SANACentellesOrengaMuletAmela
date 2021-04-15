package es.uji.ei102720coma.SANA.dao;


import es.uji.ei102720coma.SANA.model.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ControladorDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addControlador(Controlador controlador) {
        jdbcTemplate.update("INSERT INTO Controlador VALUES(?, ?, ?, ?, ?)",
                controlador.getDni(),
                controlador.getNom(),
                controlador.getCognom(),
                controlador.getEmail(),
                controlador.getAdresa());
    }

    public void deleteControlador(String dni) {
        jdbcTemplate.update("DELETE FROM Controlador WHERE dni =?", dni);
    }

    public void deleteControlador(Controlador controlador) {
        jdbcTemplate.update("DELETE FROM Controlador WHERE dni =?", controlador.getDni());
    }

    public void updateControlador(Controlador controlador) {
        jdbcTemplate.update("UPDATE Controlador SET nom =?, cognom =?, email =?, adreça =? WHERE dni =?",
                controlador.getNom(),
                controlador.getCognom(),
                controlador.getEmail(),
                controlador.getAdresa(),
                controlador.getDni());
    }

    public Controlador getControlador(String dni) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Controlador WHERE dni =?", new ControladorRowMapper(), dni);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Controlador> getControladors() {
        try {
            return jdbcTemplate.query("SELECT * FROM Controlador", new ControladorRowMapper());
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
