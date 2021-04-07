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
        reserva.setNom_espai(rs.getString("nom_espai"));
        reserva.setData_creacio(rs.getObject("data_cracio", LocalDate.class));
        reserva.setEstat(rs.getString("estat"));
        reserva.setNum_persones(rs.getInt("num_persones"));
        reserva.setData_asignacio(rs.getObject("data_asignacio", LocalDate.class));
        reserva.setData_expiracio(rs.getObject("data_expiracio", LocalDate.class));
        reserva.setHora_inici_espai(rs.getObject("hora_inici_espai", LocalTime.class));
        reserva.setHora_fi_espai(rs.getObject("hora_fi_espai", LocalTime.class));

        return reserva;
    }
}


