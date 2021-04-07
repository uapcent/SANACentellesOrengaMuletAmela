package es.uji.ei102720coma.SANA.model;

import java.time.LocalDate;

public class GestorMunicipal {

    private String dni;
    private String nom;
    private String cognoms;
    private String nomUsuari;
    private String email;
    private String contrasenya;
    private LocalDate dataNaixement;
    private String nomMunicipi;

    public GestorMunicipal() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getNomMunicipi() {
        return nomMunicipi;
    }

    public void setNomMunicipi(String nomMunicipi) {
        this.nomMunicipi = nomMunicipi;
    }

    @Override
    public String toString() {
        return "GestorMunicipal{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", nomUsuari='" + nomUsuari + '\'' +
                ", email='" + email + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", dataNaixement=" + dataNaixement +
                ", nomMunicipi='" + nomMunicipi + '\'' +
                '}';
    }
}
