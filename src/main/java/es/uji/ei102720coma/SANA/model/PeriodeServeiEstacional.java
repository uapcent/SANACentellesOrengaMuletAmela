package es.uji.ei102720coma.SANA.model;

import java.time.LocalDate;

public class PeriodeServeiEstacional {

    private String nom_espai;
    private String nom_servei_estacional;
    private LocalDate data_inici;
    private LocalDate data_fi;

    public PeriodeServeiEstacional(){}

    public String getNomEspai() {
        return nom_espai;
    }

    public void setNomEspai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    public String getNomServeiEstacional() {
        return nom_servei_estacional;
    }

    public void setNomServeiEstacional(String nom_servei_estacional) {
        this.nom_servei_estacional = nom_servei_estacional;
    }

    public LocalDate getDataInici() {
        return data_inici;
    }

    public void setDataInici(LocalDate data_inici) {
        this.data_inici = data_inici;
    }

    public LocalDate getDataFi() {
        return data_fi;
    }

    public void setDataFi(LocalDate data_fi) {
        this.data_fi = data_fi;
    }

    @Override
    public String toString() {
        return "PeriodeServeiEstacional{" +
                "nom_espai='" + nom_espai + '\'' +
                ", nom_servei_estacional='" + nom_servei_estacional + '\'' +
                ", data_inici='" + data_inici + '\'' +
                ", data_fi='" + data_fi + '\'' +
                '}';
    }
}