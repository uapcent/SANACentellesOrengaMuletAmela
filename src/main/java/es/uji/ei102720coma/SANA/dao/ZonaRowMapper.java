package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Zona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZonaRowMapper implements RowMapper<Zona> {
    public Zona mapRow(ResultSet rs, int rowNum) throws SQLException{
        Zona zona = new Zona();
        zona.setNom_espai(rs.getString("nom_spai"));
        zona.setCodiZona(rs.getString("codi"));
        zona.setLlargaria(rs.getDouble("llargaria"));
        zona.setAmplaria(rs.getDouble("amplaria"));
        zona.setCapacitatMaxima(rs.getInt("capacitat_maxima"));
        return zona;
    }
}
