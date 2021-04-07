package es.uji.ei102720coma.SANA.model;

import java.time.LocalDate;

public class Ciutada {

    private String dniCiutada;
    private String nom;
    private String cognom;

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private LocalDate dataNaixement;
    private String adreça;

    public Ciutada(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDniCiutada() {
        return dniCiutada;
    }

    public void setDniCiutada(String dniCiutada) {
        this.dniCiutada = dniCiutada;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    @Override
    public String toString() {
        return "Ciutada{" +
                "dniCiutada='" + dniCiutada + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", email='" + email + '\'' +
                ", dataNaixement=" + dataNaixement +
                ", adreça='" + adreça + '\'' +
                '}';
    }
}
