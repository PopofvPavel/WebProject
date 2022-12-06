package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.Ship;

import java.util.List;

public interface PiersDAO {
    List<Pier> getAllPiersList();

    void updatePier(Pier pier);

    void deletePier(Pier pier);

    Pier getPierByShip(Ship ship);

    void insertPier(Pier pier);

}
