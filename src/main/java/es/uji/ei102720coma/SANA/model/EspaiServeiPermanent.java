package es.uji.ei102720coma.SANA.model;

public class EspaiServeiPermanent {

    private String nomEspai;
	private String nomServeiPermanent;

    public EspaiServeiPermanent() {

    }

    public String getNomEspai() {
        return nomEspai;
    }

    public void setNomEspai(String nomEspai) {
        this.nomEspai = nomEspai;
    }

    public String getNomServeiPermanent() {
        return nomServeiPermanent;
    }

    public void setNomServeiPermanent(String nomServeiPermanent) {
        this.nomServeiPermanent = nomServeiPermanent;
    }
	
    @Override
    public String toString() {
        return "EspaiServeiPermanent{" +
                "nom_espai='" + nomEspai + '\'' +
                ", nom_servei_perm=" + nomServeiPermanent +
                '}';
    }
}