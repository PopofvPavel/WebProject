package ru.rsreu.datalayer.data;

public class Pier {
    private int idPier;
    private PierStatus status;
    private Integer idShip;//or int

    public Pier(int idPier, PierStatus status, Integer idShip) {
        this.idPier = idPier;
        this.status = status;
        this.idShip = idShip;
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

    public Integer getIdShip() {
        return idShip;
    }

    public void setIdShip(Integer idShip) {
        this.idShip = idShip;
    }

    @Override
    public String toString() {
        return "Pier{" +
                "idPier=" + idPier +
                ", status=" + status +
                ", isShip=" + idShip +
                '}';
    }
}
