package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Email;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailRowMapper implements RowMapper<Email> {

    @Override
    public Email mapRow(ResultSet rs, int rowNum) throws SQLException {
        Email email = new Email();
        email.setEmail(rs.getString("email"));
        email.setContrasenya(rs.getString("contrasenya"));
        return email;
    }
}
