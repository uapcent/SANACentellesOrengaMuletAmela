package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.FranjaEspai;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FranjaEspaiRowMapper implements RowMapper<FranjaEspai> {
    public FranjaEspai mapRow(ResultSet rs, int rowNum) throws SQLException{
        FranjaEspai franjaEspai = new FranjaEspai();
        franjaEspai.setTempsInici(rs.getInt("tempsInici"));
        franjaEspai.setTempsFi(rs.getInt("tempsFi"));
        return franjaEspai;
    }
}
