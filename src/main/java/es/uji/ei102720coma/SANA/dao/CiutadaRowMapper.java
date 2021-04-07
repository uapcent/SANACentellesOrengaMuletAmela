package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Ciutada;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CiutadaRowMapper implements RowMapper<Ciutada> {
    public Ciutada mapRow(ResultSet rs, int rowNum) throws SQLException{
        Ciutada ciutada = new Ciutada();
        ciutada.setDniCiutada(rs.getString("dniCiutada"));
        ciutada.setNom(rs.getString("nom"));
        ciutada.setCognom(rs.getString("cognom"));
        ciutada.setEmail(rs.getString("email"));
        ciutada.setDataNaixement(rs.getObject("dataNaixement", LocalDate.class));
        ciutada.setAdreça(rs.getString("adreça"));
        return ciutada;
    }
}
