package es.uji.ei102720coma.SANA.model;

import java.time.LocalTime;

public class FranjaEspai {

    private String nom_espai;
    private LocalTime hora_inici;
    private LocalTime hora_fi;

    public String getNom_espai() {
        return nom_espai;
    }

    public void setNom_espai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    public LocalTime getHora_inici() {
        return hora_inici;
    }

    public void setHora_inici(LocalTime hora_inici) {
        this.hora_inici = hora_inici;
    }

    public LocalTime getHora_fi() {
        return hora_fi;
    }

    public void setHora_fi(LocalTime hora_fi) {
        this.hora_fi = hora_fi;
    }

    @Override
    public String toString() {
        return "FranjaEspai{" +
                "nom_espai='" + nom_espai + '\'' +
                ", hora_inici=" + hora_inici +
                ", hora_fi=" + hora_fi +
                '}';
    }
}
