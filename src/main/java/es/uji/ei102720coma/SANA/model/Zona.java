package es.uji.ei102720coma.SANA.model;

public class Zona {
    private String nomEspai;
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

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nomEspai) {
        this.nomEspai = nomEspai;
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
                "nom_espai='" + nomEspai + '\'' +
                ", codi=" + codi +
                ", amplaria=" + amplaria +
                ", llargaria=" + llargaria +
                ", capacitatMaxima=" + capacitatMaxima +
                ", codiZona='" + codiZona + '\'' +
                '}';
    }
}
