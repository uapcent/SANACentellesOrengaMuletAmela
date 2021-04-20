package es.uji.ei102720coma.SANA.model;

public class Zona {
    private String nomEspai;
    private String codi;
    private double llargaria;
    private double amplaria;
    private int capacitatMaxima;


    public int getCapacitatMaxima() {
        return capacitatMaxima;
    }

    public void setCapacitatMaxima(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
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

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "nom_espai='" + nomEspai + '\'' +
                ", codi=" + codi +
                ", amplaria=" + amplaria +
                ", llargaria=" + llargaria +
                ", capacitat_maxima=" + capacitatMaxima +
                '}';
    }
}