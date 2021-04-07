package es.uji.ei102720coma.SANA.model;

import java.time.LocalDate;

public class Reserva {

    private String codiReserva;
    private LocalDate dataAsignada;
    private int numPersones;
    private EstatReserva estatReserva;
    private LocalDate dataExpiracio;
    private LocalDate data;

    public String getCodiReserva() {
        return codiReserva;
    }

    public void setCodiReserva(String codiReserva) {
        this.codiReserva = codiReserva;
    }

    public LocalDate getDataAsignada() {
        return dataAsignada;
    }

    public void setDataAsignada(LocalDate dataAsignada) {
        this.dataAsignada = dataAsignada;
    }

    public int getNumPersones() {
        return numPersones;
    }

    public void setNumPersones(int numPersones) {
        this.numPersones = numPersones;
    }

    public EstatReserva getEstatReserva() {
        return estatReserva;
    }

    public void setEstatReserva(EstatReserva estatReserva) {
        this.estatReserva = estatReserva;
    }

    public LocalDate getDataExpiracio() {
        return dataExpiracio;
    }

    public void setDataExpiracio(LocalDate dataExpiracio) {
        this.dataExpiracio = dataExpiracio;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codiReserva='" + codiReserva + '\'' +
                ", dataAsignada=" + dataAsignada +
                ", numPersones=" + numPersones +
                ", estatReserva=" + estatReserva +
                ", dataExpiracio=" + dataExpiracio +
                ", data=" + data +
                '}';
    }
}
