package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.FranjaEspai;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class FranjaEspaiRowMapper implements RowMapper<FranjaEspai> {
    public FranjaEspai mapRow(ResultSet rs, int rowNum) throws SQLException{
        FranjaEspai franjaEspai = new FranjaEspai();
        franjaEspai.setNom_espai(rs.getString("nom_espai"));
        franjaEspai.setHora_inici(rs.getObject("hora_inici", LocalTime.class));
        franjaEspai.setHora_fi(rs.getObject("hora_fi", LocalTime.class));
        return franjaEspai;
    }
}
