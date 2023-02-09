package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.Ship;

/**
 * DAO for captain action
 */
public interface CaptainActionDAO {
    /**
     * sends request
     * @param request
     * @return
     */
    boolean
    sendRequest(Request request);

    /**
     * cancels request
     * @param request
     */
    void cancelRequest(Request request);

    /**
     * cancels request
     * @param idRequest
     */
    void cancelRequest(int idRequest);

    /**
     * moves ship to pier
     * @param ship
     * @param pier
     */
    void moveShipToPier(Ship ship, Pier pier);

    /**
     * moves ship to pier
     * @param ship
     */
    void moveShipFromPier(Ship ship);

    /**
     * gets ship by cap id
     * @param idCaptain
     * @return
     */
    Ship getShipByCaptainId(int idCaptain);


    //Pier askForEmptyPier();
//    boolean askForPilot();
//    void giveShipControlToPilot(Ship ship);


}
