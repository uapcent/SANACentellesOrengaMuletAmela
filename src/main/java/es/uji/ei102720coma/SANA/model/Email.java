package es.uji.ei102720coma.SANA.model;

public class Email {

    private String email;
    private String contrasenya;

    public Email() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                '}';
    }
}
