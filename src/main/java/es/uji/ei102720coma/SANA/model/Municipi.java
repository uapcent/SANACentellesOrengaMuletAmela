package es.uji.ei102720coma.SANA.model;

public class Municipi {

    private String nom;
    private String localitzacioGeografica;
    private String provincia;
    private int codPostal;

    public Municipi() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLocalitzacioGeografica(String localitzacioGeografica) {
        this.localitzacioGeografica = localitzacioGeografica;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalitzacioGeografica() {
        return localitzacioGeografica;
    }

    @Override
    public String toString() {
        return "Municipi{" +
                "nom='" + nom + '\'' +
                ", localitzacioGeografica='" + localitzacioGeografica + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codPostal=" + codPostal +
                '}';
    }
}
