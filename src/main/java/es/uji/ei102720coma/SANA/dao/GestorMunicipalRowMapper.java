package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.GestorMunicipal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorMunicipalRowMapper implements RowMapper<GestorMunicipal> {

    @Override
    public GestorMunicipal mapRow(ResultSet rs, int rowNum) throws SQLException {
        GestorMunicipal gestorMunicipal = new GestorMunicipal();
        gestorMunicipal.setDni(rs.getString("dni"));
        gestorMunicipal.setNom(rs.getString("nom"));
        gestorMunicipal.setCognoms(rs.getString("cognoms"));
        gestorMunicipal.setNomUsuari(rs.getString("nom_usuari"));
        gestorMunicipal.setEmail(rs.getString("email"));
        gestorMunicipal.setContrasenya(rs.getString("contrasenya"));
        gestorMunicipal.setDataNaixement(rs.getObject("data_naixement", LocalDate.class));
        gestorMunicipal.setNomMunicipi(rs.getString("nom_municipi"));
        return gestorMunicipal;
    }
}
