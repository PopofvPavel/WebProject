package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.Ship;


public interface CaptainActionDAO {
    boolean
    sendRequest(Request request);

    void cancelRequest(Request request);

    void cancelRequest(int idRequest);

    void moveShipToPier(Ship ship, Pier pier);

    void moveShipFromPier(Ship ship);

    Ship getShipByCaptainId(int idCaptain);


    //Pier askForEmptyPier();
//    boolean askForPilot();
//    void giveShipControlToPilot(Ship ship);


}
