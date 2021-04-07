package es.uji.ei102720coma.SANA.model;

public class FranjaEspai {

    private int tempsInici;
    private int tempsFi;

    public FranjaEspai(){}

    public int getTempsInici() {
        return tempsInici;
    }

    public void setTempsInici(int tempsInici) {
        this.tempsInici = tempsInici;
    }

    public int getTempsFi() {
        return tempsFi;
    }

    public void setTempsFi(int tempsFi) {
        this.tempsFi = tempsFi;
    }

    @Override
    public String toString() {
        return "FranjaEspai{" +
                "tempsInici=" + tempsInici +
                ", tempsFi=" + tempsFi +
                '}';
    }
}
