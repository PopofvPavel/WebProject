package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.ShipsDAO;
import ru.rsreu.datalayer.data.Ship;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleShipsDAO implements ShipsDAO {
    private Connection connection;

    public OracleShipsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Ship> getAllPiersList() {
        List<Ship> list = new ArrayList<Ship>();
        String request = "SELECT * FROM SHIPS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                int idShip = rs.getInt(1);
                int idCap = rs.getInt(2);
                String name = rs.getString(3);

                /*     Integer idShip = Integer.valueOf(rs.getString(3));*/
                System.out.println("SHIP " + idShip + idCap + name);

                list.add(new Ship(idShip, idCap, name));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public Ship getShipByCaptainId(int id) {
        List<Ship> ships = this.getAllPiersList();
        for (Ship ship : ships) {
            if (ship.getIdCaptain() == id) {
                return ship;
            }
        }
        return null;
    }


}

