package es.uji.ei102720coma.SANA.model;

public class ReservaZona {
	private String codiReserva;
    private String nomEspai;
    private String nomZona;


    public String getCodiReserva() {
        return codiReserva;
    }

    public void setCodiReserva(String codiReserva) {
        this.codiReserva = codiReserva;
    }

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nomEspai) {
        this.nomEspai = nomEspai;
    }

    public String getNomZona() {
        return nomZona;
    }

    public void setNomZona(String nomZona) {
        this.nomZona = nomZona;
    }

    @Override
    public String toString() {
        return "ReservaZona{" +
                "codi_reserva='" + codiReserva + '\'' +
                ", nom_espai=" + nomEspai +
                ", nom_zona='" + nomZona +
                '}';
    }
}