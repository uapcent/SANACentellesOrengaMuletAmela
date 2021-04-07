package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

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
                reserva.getNom_espai(),
                reserva.getData_creacio(),
                reserva.getEstat(),
                reserva.getNum_persones(),
                reserva.getData_asignacio(),
                reserva.getData_expiracio(),
                reserva.getHora_inici_espai(),
                reserva.getHora_fi_espai());
    }

    /* Esborra la reserva de la base de dades */
    public void deleteProva(Reserva reserva) {
        jdbcTemplate.update("DELETE FROM Reserva WHERE nom = '" + reserva.getCodi() + "'");

    }

    /* Esborra la reserva de la base de dades */
    public void deleteProva(String codi) {
        jdbcTemplate.update("DELETE FROM Reserva WHERE nom = '" + codi + "'");

    }


    /* Actualitza els atributs de la prova
       (excepte el nom, que és la clau primària) */
    public void updateReserva(Reserva reserva) {
        jdbcTemplate.update("UPDATE Reserva SET dni = ?, nom_espai = ?, data_creacio = ?, estat = ?, num_persones = ?, data_asignacio = ?, data_expiracio = ?, hora_inici_espai = ?, hora_fi_espai = ? WHERE codi =?",
                reserva.getDni(),
                reserva.getNom_espai(),
                reserva.getData_creacio(),
                reserva.getEstat(),
                reserva.getNum_persones(),
                reserva.getData_asignacio(),
                reserva.getData_expiracio(),
                reserva.getHora_inici_espai(),
                reserva.getHora_fi_espai(),
                reserva.getCodi());
    }

    /* Obté la Reserva amb el codi donat. Torna null si no existeix. */
    public Reserva getReserva(String codiReserva) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Reserva WHERE nom =?",
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
                    "SELECT * FROM Reserva",
                    new ReservaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
