package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Reserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaRowMapper implements RowMapper<Reserva> {
    public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException{
        Reserva reserva = new Reserva();

        reserva.setCodi(rs.getString("codi"));
        reserva.setDni(rs.getString("dni"));
        reserva.setNomEspai(rs.getString("nom_espai"));
        reserva.setDataCreacio(rs.getObject("data_creacio", LocalDate.class));
        reserva.setEstat(rs.getString("estat"));
        reserva.setNumPersones(rs.getInt("num_persones"));
        reserva.setDataAsignacio(rs.getObject("data_asignacio", LocalDate.class));
        reserva.setDataExpiracio(rs.getObject("data_expiracio", LocalDate.class));
        reserva.setHoraIniciEspai(rs.getObject("hora_inici_espai", LocalTime.class));
        reserva.setHoraFiEspai(rs.getObject("hora_fi_espai", LocalTime.class));
        return reserva;
    }
}


