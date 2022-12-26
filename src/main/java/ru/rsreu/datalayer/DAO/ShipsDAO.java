package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Ship;

import java.util.List;

public interface ShipsDAO {
    List<Ship> getAllPiersList();

    Ship getShipByCaptainId(int id);
}
