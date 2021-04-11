package es.uji.ei102720coma.SANA.model;

public class ControladorEspai {

    private String dni_controlador;
    private String nom_espai;

    public String getDniControlador() {
        return dni_controlador;
    }

    public void setDniControlador(String dni_controlador) {
        this.dni_controlador = dni_controlador;
    }

    public String getNomEspai() {
        return nom_espai;
    }

    public void setNomEspai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    @Override
    public String toString() {
        return "ControladorEspai{" +
                "dni_controlador='" + dni_controlador + '\'' +
                ", nom_espai='" + nom_espai + '\'' +
                '}';
    }
}