package ru.rsreu.datalayer.data;

public class Pier {
    private int idPier;
    private PierStatus status;
    private int isShip;

    public Pier(int idPier, PierStatus status, int isShip) {
        this.idPier = idPier;
        this.status = status;
        this.isShip = isShip;
    }

    public int getIdPier() {
        return idPier;
    }

    public void setIdPier(int idPier) {
        this.idPier = idPier;
    }

    public PierStatus getStatus() {
        return status;
    }

    public void setStatus(PierStatus status) {
        this.status = status;
    }

    public int getIsShip() {
        return isShip;
    }

    public void setIsShip(int isShip) {
        this.isShip = isShip;
    }

    @Override
    public String toString() {
        return "Pier{" +
                "idPier=" + idPier +
                ", status=" + status +
                ", isShip=" + isShip +
                '}';
    }
}
