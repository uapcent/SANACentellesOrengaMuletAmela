package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Controlador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorRowMapper implements RowMapper<Controlador> {

    @Override
    public Controlador mapRow(ResultSet rs, int rowNum) throws SQLException {
        Controlador controlador = new Controlador();
        controlador.setDni(rs.getString("dni"));
        controlador.setNom(rs.getString("nom"));
        controlador.setCognom(rs.getString("cognom"));
        controlador.setEmail(rs.getString("email"));
        controlador.setAdresa(rs.getString("adreça"));
        return controlador;
    }
}
