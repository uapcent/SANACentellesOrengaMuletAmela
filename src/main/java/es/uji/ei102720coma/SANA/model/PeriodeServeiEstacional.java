package es.uji.ei102720coma.SANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PeriodeServeiEstacional {

    private String nomEspai;
    private String nomServeiEstacional;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInici;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFi;

    public PeriodeServeiEstacional(){}

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nomEspai) {
        this.nomEspai = nomEspai;
    }

    public String getNomServeiEstacional() {
        return nomServeiEstacional;
    }

    public void setNomServeiEstacional(String nomServeiEstacional) {
        this.nomServeiEstacional = nomServeiEstacional;
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
        return "PeriodeServeiEstacional{" +
                "nom_espai='" + nomEspai + '\'' +
                ", nom_servei_est='" + nomServeiEstacional + '\'' +
                ", data_inici='" + dataInici + '\'' +
                ", data_fi='" + dataFi + '\'' +
                '}';
    }
}