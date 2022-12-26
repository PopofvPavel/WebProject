package ru.rsreu.datalayer.data;

public class Ship {
    private int idShip;
    private int idCaptain;
    private String name;

    public Ship(int idShip, int isCaptain, String name) {
        this.idShip = idShip;
        this.idCaptain = isCaptain;
        this.name = name;
    }

    public int getIdShip() {
        return idShip;
    }

    public void setIdShip(int idShip) {
        this.idShip = idShip;
    }

    public int getIdCaptain() {
        return idCaptain;
    }

    public void setIdCaptain(int idCaptain) {
        this.idCaptain = idCaptain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "idShip=" + idShip +
                ", isCaptain=" + idCaptain +
                ", name='" + name + '\'' +
                '}';
    }
}
