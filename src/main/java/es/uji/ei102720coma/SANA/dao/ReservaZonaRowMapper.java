package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.ReservaZona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservaZonaRowMapper implements RowMapper<ReservaZona> {

    @Override
    public ReservaZona mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReservaZona reserva = new ReservaZona();
		reserva.setCodiReserva(rs.getString("codi_reserva"));
        reserva.setNomEspai(rs.getString("nom_espai"));
        reserva.setNomZona(rs.getString("nom_zona"));
        return reserva;
    }
}