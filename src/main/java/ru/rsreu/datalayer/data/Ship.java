package ru.rsreu.datalayer.data;

/**
 * captain ship
 */
public class Ship {
    private int idShip;
    private int idCaptain;
    private String name;

    /**
     * constructor
     * @param idShip
     * @param isCaptain
     * @param name
     */
    public Ship(int idShip, int isCaptain, String name) {
        this.idShip = idShip;
        this.idCaptain = isCaptain;
        this.name = name;
    }

    /**
     * id getter
     * @return
     */
    public int getIdShip() {
        return idShip;
    }

    /**
     * id setter
     * @param idShip
     */
    public void setIdShip(int idShip) {
        this.idShip = idShip;
    }

    /**
     * captain id getter
     * @return
     */
    public int getIdCaptain() {
        return idCaptain;
    }

    /**
     * captain id setter
     * @param idCaptain
     */
    public void setIdCaptain(int idCaptain) {
        this.idCaptain = idCaptain;
    }

    /**
     * name getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Ship{" +
                "idShip=" + idShip +
                ", isCaptain=" + idCaptain +
                ", name='" + name + '\'' +
                '}';
    }
}
