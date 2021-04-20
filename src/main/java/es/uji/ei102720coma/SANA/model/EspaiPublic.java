package es.uji.ei102720coma.SANA.model;

public class EspaiPublic {

    private String nom;
    private String tipusAcces;
    private String tipusSol;
    private String tipusEspai;
    private String localitzacioGeografica;
    private String descripcio;
    private double llargaria;
    private double amplaria;
    private String orientacio;
    private String comentaris;
    private String imatges;
    private String nomMunicipi;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipusAccess() {
        return tipusAcces;
    }

    public void setTipusAccess(String tipusAcces) {
        this.tipusAcces = tipusAcces;
    }

    public String getTipusSol() {
        return tipusSol;
    }

    public void setTipusSol(String tipusSol) {
        this.tipusSol = tipusSol;
    }

    public String getTipusEspai() {
        return tipusEspai;
    }

    public void setTipusEspai(String tipusEspai) {
        this.tipusEspai = tipusEspai;
    }

    public String getLocalitzacioGeografica() {
        return localitzacioGeografica;
    }

    public void setLocalitzacioGeografica(String localitzacioGeografica) {
        this.localitzacioGeografica = localitzacioGeografica;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getLlargaria() {
        return llargaria;
    }

    public void setLlargaria(double llargaria) {
        this.llargaria = llargaria;
    }

    public double getAmplaria() {
        return amplaria;
    }

    public void setAmplaria(double amplaria) {
        this.amplaria = amplaria;
    }

    public String getOrientacio() {
        return orientacio;
    }

    public void setOrientacio(String orientacio) {
        this.orientacio = orientacio;
    }

    public String getComentaris() {
        return comentaris;
    }

    public void setComentaris(String comentaris) {
        this.comentaris = comentaris;
    }

    public String getImatges() {
        return imatges;
    }

    public void setImatges(String imatges) {
        this.imatges = imatges;
    }

    public String getNomMunicipi() {
        return nomMunicipi;
    }

    public void setNomMunicipi(String nomMunicipi) {
        this.nomMunicipi = nomMunicipi;
    }

    @Override
    public String toString() {
        return "EspaiPublic{" +
                "nom='" + nom + '\'' +
                ", tipusAcces='" + tipusAcces + '\'' +
                ", tipusSol='" + tipusSol + '\'' +
                ", tipusEspai='" + tipusEspai + '\'' +
                ", localitzacioGeografica='" + localitzacioGeografica + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", llargaria=" + llargaria +
                ", amplaria=" + amplaria +
                ", orientacio='" + orientacio + '\'' +
                ", comentaris='" + comentaris + '\'' +
                ", imatges='" + imatges + '\'' +
                ", nomMunicipi='" + nomMunicipi + '\'' +
                '}';
    }
}
