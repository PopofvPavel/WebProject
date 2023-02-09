package ru.rsreu.datalayer.data;

/**
 * Pier where you can store ship
 */
public class Pier {
    private int idPier;
    private PierStatus status;
    private Integer idShip;//or int

    /**
     * Constructor for new pier, which needs id, status and ship id
     * @param idPier
     * @param status
     * @param idShip
     */
    public Pier(int idPier, PierStatus status, Integer idShip) {
        this.idPier = idPier;
        this.status = status;
        this.idShip = idShip;
    }

    /**
     * id pier getter
     * @return
     */
    public int getIdPier() {
        return idPier;
    }

    /**
     * id pier setter
     * @param idPier
     */
    public void setIdPier(int idPier) {
        this.idPier = idPier;
    }

    /**
     * status getter
     * @return
     */
    public PierStatus getStatus() {
        return status;
    }

    /**
     * status setter
     * @param status
     */
    public void setStatus(PierStatus status) {
        this.status = status;
    }

    /**
     * id ship getter
     * @return
     */
    public Integer getIdShip() {
        return idShip;
    }

    /**
     * id ship setter
     * @param idShip
     */
    public void setIdShip(Integer idShip) {
        this.idShip = idShip;
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Pier{" +
                "idPier=" + idPier +
                ", status=" + status +
                ", isShip=" + idShip +
                '}';
    }
}
