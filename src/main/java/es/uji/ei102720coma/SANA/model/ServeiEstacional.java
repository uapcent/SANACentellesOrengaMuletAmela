package es.uji.ei102720coma.SANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public class ServeiEstacional {

    private String nom;
    private String llocContracte;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInici;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaFi;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlocContracte() {
        return llocContracte;
    }

    public void setLlocContracte(String llocContracte) {
        this.llocContracte = llocContracte;
    }

    public LocalTime getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(LocalTime horaInici) {
        this.horaInici = horaInici;
    }

    public LocalTime getHoraFi() {
        return horaFi;
    }

    public void setHoraFi(LocalTime horaFi) {
        this.horaFi = horaFi;
    }

    @Override
    public String toString() {
        return "Servei_Estacional{" +
                "nom='" + nom + '\'' +
                ", lloc_contracte='" + llocContracte + '\'' +
                ", hora_inici=" + horaInici +
                ", hora_fi=" + horaFi +
                '}';
    }
}
