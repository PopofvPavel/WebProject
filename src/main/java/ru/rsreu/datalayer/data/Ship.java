package ru.rsreu.datalayer.data;

public class Ship {
    private int idShip;
    private int isCaptain;
    private String name;

    public Ship(int idShip, int isCaptain, String name) {
        this.idShip = idShip;
        this.isCaptain = isCaptain;
        this.name = name;
    }

    public int getIdShip() {
        return idShip;
    }

    public void setIdShip(int idShip) {
        this.idShip = idShip;
    }

    public int getIsCaptain() {
        return isCaptain;
    }

    public void setIsCaptain(int isCaptain) {
        this.isCaptain = isCaptain;
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
                ", isCaptain=" + isCaptain +
                ", name='" + name + '\'' +
                '}';
    }
}
