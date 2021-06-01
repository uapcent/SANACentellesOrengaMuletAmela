package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservaDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*Afegir Reserva a la base de dades*/
    public void addReserva(Reserva reserva){
        jdbcTemplate.update("INSERT INTO Reserva VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                reserva.getCodi(),
                reserva.getDni(),
                reserva.getNomEspai(),
                reserva.getDataCreacio(),
                reserva.getEstat(),
                reserva.getNumPersones(),
                reserva.getDataAsignacio(),
                reserva.getDataExpiracio(),
                reserva.getHoraIniciEspai(),
                reserva.getHoraFiEspai());
    }

    /* Esborra la reserva de la base de    dades */
    public void deleteReserva(Reserva reserva) {
        jdbcTemplate.update("DELETE FROM Reserva WHERE codi = '" + reserva.getCodi() + "'");

    }

    /* Esborra la reserva de la base de dades */
    public void deleteReserva(String codi) {
        jdbcTemplate.update("DELETE FROM Reserva WHERE codi = '" + codi + "'");

    }

    /* Esborra la reserva de la base de dades */
    public void cancelReserva(String codi) {
        jdbcTemplate.update("UPDATE Reserva SET estat = 'cancel·lada' WHERE codi = '" + codi + "'");

    }

    /* Actualitza els atributs de la prova
       (excepte el nom, que és la clau primària) */
    public void updateReserva(Reserva reserva) {
        jdbcTemplate.update("UPDATE Reserva SET dni = ?, nom_espai = ?, data_creacio = ?, estat = ?, num_persones = ?, data_asignacio = ?, data_expiracio = ?, hora_inici_espai = ?, hora_fi_espai = ? WHERE codi =?",
                reserva.getDni(),
                reserva.getNomEspai(),
                reserva.getDataCreacio(),
                reserva.getEstat(),
                reserva.getNumPersones(),
                reserva.getDataAsignacio(),
                reserva.getDataExpiracio(),
                reserva.getHoraIniciEspai(),
                reserva.getHoraFiEspai(),
                reserva.getCodi());
    }

    /* Obté la Reserva amb el codi donat. Torna null si no existeix. */
    public Reserva getReserva(String codiReserva) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Reserva WHERE codi =?",
                    new ReservaRowMapper(),
                    codiReserva);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté totes les receptes. Torna una llista buida si no n'hi ha cap. */
    public List<Reserva> getReserves() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Reserva ORDER BY codi",
                    new ReservaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    public List<Reserva> getReserves(String dni_ciutada) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Reserva WHERE dni=?", new ReservaRowMapper(), dni_ciutada);
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
