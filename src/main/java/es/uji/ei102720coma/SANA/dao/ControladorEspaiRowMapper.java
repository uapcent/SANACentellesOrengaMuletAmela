package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.ControladorEspai;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorEspaiRowMapper implements RowMapper<ControladorEspai> {

    @Override
    public ControladorEspai mapRow(ResultSet rs, int rowNum) throws SQLException {
        ControladorEspai controlador = new ControladorEspai();
        controlador.setDniControlador(rs.getString("dni_controlador"));
        controlador.setNomEspai(rs.getString("nom_espai"));
        return controlador;
    }
}