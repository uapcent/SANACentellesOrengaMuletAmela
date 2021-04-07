package es.uji.ei102720coma.SANA.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private String codi;
    private String dni;
    private String nom_espai;
    private LocalDate data_creacio;
    private String estat;
    private int num_persones;
    private LocalDate data_asignacio;
    private LocalDate data_expiracio;
    private LocalTime hora_inici_espai;
    private LocalTime hora_fi_espai;

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

    public String getNom_espai() {
        return nom_espai;
    }

    public void setNom_espai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    public LocalDate getData_creacio() {
        return data_creacio;
    }

    public void setData_creacio(LocalDate data_creacio) {
        this.data_creacio = data_creacio;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public int getNum_persones() {
        return num_persones;
    }

    public void setNum_persones(int num_persones) {
        this.num_persones = num_persones;
    }

    public LocalDate getData_asignacio() {
        return data_asignacio;
    }

    public void setData_asignacio(LocalDate data_asignacio) {
        this.data_asignacio = data_asignacio;
    }

    public LocalDate getData_expiracio() {
        return data_expiracio;
    }

    public void setData_expiracio(LocalDate data_expiracio) {
        this.data_expiracio = data_expiracio;
    }

    public LocalTime getHora_inici_espai() {
        return hora_inici_espai;
    }

    public void setHora_inici_espai(LocalTime hora_inici_espai) {
        this.hora_inici_espai = hora_inici_espai;
    }

    public LocalTime getHora_fi_espai() {
        return hora_fi_espai;
    }

    public void setHora_fi_espai(LocalTime hora_fi_espai) {
        this.hora_fi_espai = hora_fi_espai;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codi='" + codi + '\'' +
                ", dni='" + dni + '\'' +
                ", nom_espai='" + nom_espai + '\'' +
                ", data_creacio=" + data_creacio +
                ", estat='" + estat + '\'' +
                ", num_persones=" + num_persones +
                ", data_asignacio=" + data_asignacio +
                ", data_expiracio=" + data_expiracio +
                ", hora_inici_espai=" + hora_inici_espai +
                ", hora_fi_espai=" + hora_fi_espai +
                '}';
    }
}
