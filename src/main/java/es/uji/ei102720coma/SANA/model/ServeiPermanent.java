package es.uji.ei102720coma.SANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServeiPermanent {

    private String nom;
    private String llocContracte;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInici;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaFi;
    private LocalDate dataInici;
    private LocalDate dataFi;

    public ServeiPermanent() {

    }

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

    public LocalDate getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }

    @Override
    public String toString() {
        return "ServeiPermanent{" +
                "nom='" + nom + '\'' +
                ", horaInici=" + horaInici +
                ", horaFi=" + horaFi +
                ", dataInici=" + dataInici +
                ", dataFi=" + dataFi +
                '}';
    }
}
