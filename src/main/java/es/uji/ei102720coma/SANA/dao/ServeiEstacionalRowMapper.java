package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.ServeiEstacional;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class ServeiEstacionalRowMapper implements RowMapper<ServeiEstacional> {

    @Override
    public ServeiEstacional mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServeiEstacional serveiEstacional = new ServeiEstacional();
        serveiEstacional.setNom(rs.getString("nom"));
        serveiEstacional.setLlocContracte(rs.getString("lloc_contracte"));
        Time tI = rs.getTime("hora_inici");
        serveiEstacional.setHoraInici(tI != null ? tI.toLocalTime() : null);
        Time tF = rs.getTime("hora_fi");
        serveiEstacional.setHoraFi(tF != null ? tF.toLocalTime() : null);
        return serveiEstacional;
    }
}