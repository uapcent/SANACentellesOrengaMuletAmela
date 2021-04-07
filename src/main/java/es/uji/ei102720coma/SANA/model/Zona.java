package es.uji.ei102720coma.SANA.model;

public class Zona {
    private String nom_espai;
    private int codi;
    private double amplaria;
    private double llargaria;
    private int capacitatMaxima;
    private String codiZona;


    public int getCapacitatMaxima() {
        return capacitatMaxima;
    }

    public void setCapacitatMaxima(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
    }

    public String getCodiZona() {
        return codiZona;
    }

    public void setCodiZona(String codiZona) {
        this.codiZona = codiZona;
    }

    public double getAmplaria() {
        return amplaria;
    }

    public void setAmplaria(double amplaria) {
        this.amplaria = amplaria;
    }

    public double getLlargaria() {
        return llargaria;
    }

    public void setLlargaria(double llargaria) {
        this.llargaria = llargaria;
    }

    public String getNom_espai() {
        return nom_espai;
    }

    public void setNom_espai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "nom_espai='" + nom_espai + '\'' +
                ", codi=" + codi +
                ", amplaria=" + amplaria +
                ", llargaria=" + llargaria +
                ", capacitatMaxima=" + capacitatMaxima +
                ", codiZona='" + codiZona + '\'' +
                '}';
    }
}
