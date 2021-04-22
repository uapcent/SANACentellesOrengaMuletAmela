package es.uji.ei102720coma.SANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public class FranjaEspai {

    private String nomEspai;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInici;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaFi;

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nomEspai) {
        this.nomEspai = nomEspai;
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
        return "FranjaEspai{" +
                "nom_espai='" + nomEspai + '\'' +
                ", hora_inici=" + horaInici +
                ", hora_fi=" + horaFi +
                '}';
    }
}
