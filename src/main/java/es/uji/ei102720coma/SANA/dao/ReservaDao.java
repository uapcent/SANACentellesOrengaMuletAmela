package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Reserva;
import es.uji.ei102720coma.SANA.services.DiaYaOcupadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
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
    public void addReserva(Reserva reserva) {

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
        jdbcTemplate.update("UPDATE Reserva SET estat = 'cancelada' WHERE codi = '" + codi + "'");

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

    public List<Reserva> getReservesZona(String nom_espai, String nom_zona, LocalDate data) throws DiaYaOcupadoException {
        try {

            List<Reserva> llista = jdbcTemplate.query(
                    "SELECT * FROM Reserva AS res JOIN Reserva_Zona AS zona ON res.codi=zona.codi_reserva WHERE estat='Activo' AND zona.nom_espai=? AND nom_zona=? AND data_asignacio=?;",
                    new ReservaRowMapper(), nom_espai, nom_zona, data);
            if (!llista.isEmpty()){
                System.out.println(llista.size());
                throw new DiaYaOcupadoException("Elige otro dia");
            }
            return llista;
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
