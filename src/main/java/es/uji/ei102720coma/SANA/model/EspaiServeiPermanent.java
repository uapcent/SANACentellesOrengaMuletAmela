package es.uji.ei102720coma.SANA.model;

public class EspaiServeiPermanent {

    private String nom_espai;
	private String nom_servei_permanent;

    public EspaiServeiPermanent() {

    }

    public String getNomEspai() {
        return nom_espai;
    }

    public void setNomEspai(String nom_espai) {
        this.nom_espai = nom_espai;
    }

    public String getNomServeiPermanent() {
        return nom_servei_permanent;
    }

    public void setNomServeiPermanent(String nom_servei_permanent) {
        this.nom_servei_permanent = nom_servei_permanent;
    }
	
    @Override
    public String toString() {
        return "EspaiServeiPermanent{" +
                "nom_espai='" + nom_espai + '\'' +
                ", nom_servei_permanent=" + nom_servei_permanent +
                '}';
    }
}