package es.uji.ei102720coma.SANA.model;

public class ReservaZona {
	private String codi_reserva;
    private String nom_espai;
    private String nom_zona;


    public String getCodiReserva() {
        return codi_reserva;
    }

    public void setCodiReserva(String codi_reserva) {
        this.codi_reserva = codi_reserva;
    }

    public String getNomEspai() {
        return nom_espai;
    }

    public void setNomEspai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    public String getNomZona() {
        return nom_zona;
    }

    public void setNomZona(String nom_zona) {
        this.nom_zona = nom_zona;
    }

    @Override
    public String toString() {
        return "ReservaZona{" +
                "codi_reserva='" + codi_reserva + '\'' +
                ", nom_espai=" + nom_espai +
                ", nom_zona='" + nom_zona + '\'' +
                '}';
    }
}