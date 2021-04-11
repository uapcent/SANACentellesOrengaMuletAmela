package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.PeriodeServeiEstacional;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PeriodeServeiEstacionalRowMapper implements RowMapper<PeriodeServeiEstacional> {

    @Override
    public PeriodeServeiEstacional mapRow(ResultSet rs, int rowNum) throws SQLException {
        PeriodeServeiEstacional servei = new PeriodeServeiEstacional();
        servei.setNomEspai(rs.getString("nom_espai"));
        servei.setNomServeiEstacional(rs.getString("nom_servei_estacional"));
        servei.setDataInici(rs.getObject("data_inici", LocalDate.class));
        servei.setDataFi(rs.getObject("data_fi", LocalDate.class));
        return servei;
    }
}