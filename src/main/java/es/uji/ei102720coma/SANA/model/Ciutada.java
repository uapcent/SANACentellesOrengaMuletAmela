package es.uji.ei102720coma.SANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Ciutada {

    private String dniCiutada;
    private String nom;
    private String cognom;
    private String email;
    private String contrasenya;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNaixement;
    private String adresa;

    public Ciutada(){}

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public String toString() {
        return "Ciutada{" +
                "dniCiutada='" + dniCiutada + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", email='" + email + '\'' +
                ", dataNaixement=" + dataNaixement +
                ", adreça='" + adresa + '\'' +
                '}';
    }
}
