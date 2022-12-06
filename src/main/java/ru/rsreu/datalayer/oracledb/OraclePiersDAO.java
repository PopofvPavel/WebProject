package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.PiersDAO;
import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.PierStatus;
import ru.rsreu.datalayer.data.Ship;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OraclePiersDAO implements PiersDAO {
    private Connection connection;

    public OraclePiersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pier> getAllPiersList() {
        List<Pier> list = new ArrayList<Pier>();
        String request = "SELECT * FROM PIERS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                int idPier = rs.getInt(1);
                PierStatus status = PierStatus.valueOf(rs.getString(2));
                Object idShipOb = rs.getString(3);
                Integer idShip = null;
                if (idShipOb != null) {
                    idShip = Integer.valueOf((String) idShipOb);
                }

           /*     Integer idShip = Integer.valueOf(rs.getString(3));*/
                System.out.println("PIERS " + idPier + status + idShip );

                list.add(new Pier(idPier,status,idShip));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public void updatePier(Pier pier) {
            String request = "UPDATE PIERS SET STATUS = ?, ID_SHIP = ? WHERE ID_PIER = ?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, pier.getStatus().name());
            preparedStatement.setInt(2, pier.getIdShip());
            preparedStatement.setInt(3, pier.getIdPier());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePier(Pier pier) {
        String request = "DELETE FROM PIERS WHERE ID_PIER = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, pier.getIdPier());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pier getPierByShip(Ship ship) {
        String request = "SELECT * FROM PIERS WHERE ID_SHIP = ?";
        Pier pier = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, ship.getIdShip());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                pier = getPierFromResultSet(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pier;
    }

    private Pier getPierFromResultSet(ResultSet rs) throws SQLException {
        int idPier = rs.getInt(1);
        String  status = rs.getString(2);
        int idShip = rs.getInt(3);

        return new Pier(idPier,PierStatus.valueOf(status),idShip);
    }

    @Override
    public void insertPier(Pier pier) {
        String insertRequest = "INSERT INTO PIERS VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertRequest);
            preparedStatement.setInt(1,pier.getIdPier());
            preparedStatement.setString(2, pier.getStatus().name());
            preparedStatement.setInt(3,pier.getIdShip());

            preparedStatement.executeUpdate();
            System.out.println("inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
