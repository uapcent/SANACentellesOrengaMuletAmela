package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.EspaiServeiPermanent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EspaiServeiPermanentRowMapper implements RowMapper<EspaiServeiPermanent> {

    @Override
    public EspaiServeiPermanent mapRow(ResultSet rs, int rowNum) throws SQLException {
        EspaiServeiPermanent espai = new EspaiServeiPermanent();
        espai.setNomEspai(rs.getString("nom_espai"));
        espai.setNomServeiPermanent(rs.getString("nom_servei_permanent"));
        return espai;
    }
}