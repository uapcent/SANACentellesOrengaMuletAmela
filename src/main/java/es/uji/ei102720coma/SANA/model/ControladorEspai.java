package es.uji.ei102720coma.SANA.model;

public class ControladorEspai {

    private String dniControlador;
    private String nomEspai;

    public String getDniControlador() {
        return dniControlador;
    }

    public void setDniControlador(String dni_controlador) {
        this.dniControlador = dni_controlador;
    }

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nom_espai) {
        this.nomEspai = nom_espai;
    }

    @Override
    public String toString() {
        return "ControladorEspai{" +
                "dni_controlador='" + dniControlador + '\'' +
                ", nom_espai='" + nomEspai + '\'' +
                '}';
    }
}