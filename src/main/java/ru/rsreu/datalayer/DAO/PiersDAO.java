package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.Ship;

import java.util.List;

/**
 * Piers DAO
 */
public interface PiersDAO {
    /**
     * returns piers list
     * @return
     */
    List<Pier> getAllPiersList();

    /**
     * updates pier
     * @param pier
     */
    void updatePier(Pier pier);

    /**
     * deletes pier
     * @param pier
     */
    void deletePier(Pier pier);

    /**
     * gets ship by pier
     * @param ship
     * @return
     */
    Pier getPierByShip(Ship ship);

    /**
     * inserts new pier
     * @param pier
     */
    void insertPier(Pier pier);

}
