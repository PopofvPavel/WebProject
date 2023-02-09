package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Ship;

import java.util.List;

/**
 * DAO for ships
 */
public interface ShipsDAO {
    /**
     * rerutns all piers list
     * @return
     */
    List<Ship> getAllPiersList();

    /**
     * gets ship by captain id
     * @param id
     * @return
     */
    Ship getShipByCaptainId(int id);
}
