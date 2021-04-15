package es.uji.ei102720coma.SANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private String codi;
    private String dni;
    private String nomEspai;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCreacio;
    private String estat;
    private int numPersones;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAsignacio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataExpiracio;
    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime horaIniciEspai;
    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private LocalTime horaFiEspai;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nomEspai) {
        this.nomEspai = nomEspai;
    }

    public LocalDate getDataCreacio() {
        return dataCreacio;
    }

    public void setDataCreacio(LocalDate dataCreacio) {
        this.dataCreacio = dataCreacio;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public int getNumPersones() {
        return numPersones;
    }

    public void setNumPersones(int numPersones) {
        this.numPersones = numPersones;
    }

    public LocalDate getDataAsignacio() {
        return dataAsignacio;
    }

    public void setDataAsignacio(LocalDate dataAsignacio) {
        this.dataAsignacio = dataAsignacio;
    }

    public LocalDate getDataExpiracio() {
        return dataExpiracio;
    }

    public void setDataExpiracio(LocalDate dataExpiracio) {
        this.dataExpiracio = dataExpiracio;
    }

    public LocalTime getHoraIniciEspai() {
        return horaIniciEspai;
    }

    public void setHoraIniciEspai(LocalTime horaIniciEspai) {
        this.horaIniciEspai = horaIniciEspai;
    }

    public LocalTime getHoraFiEspai() {
        return horaFiEspai;
    }

    public void setHoraFiEspai(LocalTime horaFiEspai) {
        this.horaFiEspai = horaFiEspai;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codi='" + codi + '\'' +
                ", dni='" + dni + '\'' +
                ", nom_espai='" + nomEspai + '\'' +
                ", data_creacio=" + dataCreacio +
                ", estat='" + estat + '\'' +
                ", num_persones=" + numPersones +
                ", data_asignacio=" + dataAsignacio +
                ", data_expiracio=" + dataExpiracio +
                ", hora_inici_espai=" + horaIniciEspai +
                ", hora_fi_espai=" + horaFiEspai +
                '}';
    }
}
