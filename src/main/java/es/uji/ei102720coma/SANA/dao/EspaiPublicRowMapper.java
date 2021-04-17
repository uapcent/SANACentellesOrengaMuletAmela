package es.uji.ei102720coma.SANA.dao;

import es.uji.ei102720coma.SANA.model.EspaiPublic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EspaiPublicRowMapper implements RowMapper<EspaiPublic> {

    @Override
    public EspaiPublic mapRow(ResultSet rs, int rowNum) throws SQLException {
        EspaiPublic espaiPublic = new EspaiPublic();
        espaiPublic.setNom(rs.getString("nom"));
        espaiPublic.setTipusAccess(rs.getString("tipus_acces"));
        espaiPublic.setTipusSol(rs.getString("tipus_sol"));
        espaiPublic.setTipusEspai(rs.getString("tipus_espai"));
        espaiPublic.setLocalitzacioGeografica(rs.getString("localitzacio_geografica"));
        espaiPublic.setDescripcio(rs.getString("descripcio"));
        espaiPublic.setLlargaria(rs.getDouble("llargaria"));
        espaiPublic.setAmplaria(rs.getDouble("amplaria"));
        espaiPublic.setOrientacio(rs.getString("orientacio"));
        espaiPublic.setComentaris(rs.getString("comentaris"));
        espaiPublic.setImatges(rs.getString("imatges"));
        espaiPublic.setNomMunicipi(rs.getString("nom_municipi"));
        return espaiPublic;
    }
}
