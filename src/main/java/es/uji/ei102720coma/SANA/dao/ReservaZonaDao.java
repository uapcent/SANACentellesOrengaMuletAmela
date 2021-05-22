package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.ReservaZona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservaZonaDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*Afegir ReservaZona a la base de dades*/
    public void addReservaZona(ReservaZona reservaZona){
        jdbcTemplate.update("INSERT INTO Reserva_Zona VALUES(?, ?, ?)",
                reservaZona.getCodiReserva(),
                reservaZona.getNomEspai(),
                reservaZona.getNomZona());
    }

    /* Esborra la reservaZona de la base de dades */
    public void deleteReservaZona(ReservaZona reservaZona) {
        jdbcTemplate.update("DELETE FROM Reserva_Zona WHERE codi_reserva =?", reservaZona.getCodiReserva());
    }



    /* Esborra la reserva de la base de dades */
    public void deleteReservaZona(String codi) {
        jdbcTemplate.update("DELETE FROM Reserva_Zona WHERE codi_reserva =?", codi);
    }


    /* Actualitza els atributs de la prova
       (excepte el nom, que és la clau primària) */
    public void updateReserva(ReservaZona reservaZona) {
        jdbcTemplate.update("UPDATE Reserva_Zona SET nom_espai = ?, nom_zona = ? WHERE codi_reserva =?",
                reservaZona.getNomEspai(),
                reservaZona.getNomZona(),
                reservaZona.getCodiReserva());
    }

    /* Obté la Reserva amb el codi donat. Torna null si no existeix. */
    public ReservaZona getReservaZona(String codiReserva) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Reserva_Zona WHERE codi_reserva =?",
                    new ReservaZonaRowMapper(),
                    codiReserva);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté totes les receptes. Torna una llista buida si no n'hi ha cap. */
    public List<ReservaZona> getReservasZonas() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Reserva_Zona",
                    new ReservaZonaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
