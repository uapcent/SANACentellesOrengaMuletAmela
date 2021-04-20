package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.FranjaEspai;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

public class FranjaEspaiRowMapper implements RowMapper<FranjaEspai> {

    @Override
    public FranjaEspai mapRow(ResultSet rs, int rowNum) throws SQLException{
        FranjaEspai franjaEspai = new FranjaEspai();
        franjaEspai.setNomEspai(rs.getString("nom_espai"));
        Time t1 = rs.getTime("hora_inici");
        franjaEspai.setHoraInici(t1 != null ? t1.toLocalTime() : null);
        Time t2 = rs.getTime("hora_fi");
        franjaEspai.setHoraFi(t2 != null ? t2.toLocalTime() : null);
        return franjaEspai;
    }
}
