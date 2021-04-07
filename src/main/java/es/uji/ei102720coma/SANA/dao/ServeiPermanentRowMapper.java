package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.ServeiPermanent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

public class ServeiPermanentRowMapper implements RowMapper<ServeiPermanent> {
    @Override
    public ServeiPermanent mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServeiPermanent serveiPermanent = new ServeiPermanent();
        serveiPermanent.setNom(rs.getString("nom"));
        serveiPermanent.setLlocContracte("lloc_contracte");
        Time tI = rs.getTime("hora_inici");
        serveiPermanent.setHoraInici(tI.toLocalTime());
        Time tF = rs.getTime("hora_fi");
        serveiPermanent.setHoraFi(tF.toLocalTime());
        serveiPermanent.setDataInici(rs.getObject("data_inici", LocalDate.class));
        serveiPermanent.setDataFi(rs.getObject("data_fi", LocalDate.class));
        return serveiPermanent;
    }
}
