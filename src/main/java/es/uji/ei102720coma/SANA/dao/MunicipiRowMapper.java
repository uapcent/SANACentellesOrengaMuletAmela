package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Municipi;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MunicipiRowMapper implements RowMapper<Municipi>{
    public Municipi mapRow(ResultSet rs, int rowNum) throws SQLException{
        Municipi municipi = new Municipi();
        municipi.setNom(rs.getString("nom"));
        municipi.setCodPostal(rs.getInt("codi_postal"));
        municipi.setProvincia(rs.getString("provincia"));
        municipi.setLocalitzacioGeografica(rs.getString("localitzacio_geografica"));
        return municipi;
    }
}
