package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.CaptainActionDAO;
import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.Ship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleCaptainActionDAO implements CaptainActionDAO {
    private final Connection connection;

    public OracleCaptainActionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean sendRequest(Request request) {
        String insertRequest = "INSERT INTO REQUESTS VALUES (?,?,?,?)";
        try {
            System.out.println(request.getRequestType().name() + '\n' + request.getRequestStatus().name());
            PreparedStatement preparedStatement = connection.prepareStatement(insertRequest);
            preparedStatement.setInt(1, request.getIdRequest());
            preparedStatement.setString(2, request.getRequestType().name());
            preparedStatement.setString(3, request.getRequestStatus().name());
            preparedStatement.setInt(4, request.getIdCaptain());

            preparedStatement.executeUpdate();
            System.out.println("inserted new request");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override//not checked
    public void cancelRequest(Request request) {
        setCanceledStatusInRequestsTable(connection, request.getIdRequest());
    }

    @Override
    public void cancelRequest(int idRequest) {
        setCanceledStatusInRequestsTable(connection, idRequest);
    }

    @Override
    public void moveShipToPier(Ship ship, Pier pier) {
        setStatusOccupiedToPier(ship.getIdShip(), pier.getIdPier());

    }

    @Override
    public void moveShipFromPier(Ship ship) {
        setStatusEmptyToPier(ship.getIdShip());

    }

    @Override
    public Ship getShipByCaptainId(int idCaptain) {//not checked
        String request = "SELECT * FROM SHIPS WHERE ID_CAPTAIN = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, idCaptain);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idShip = rs.getInt(1);
                int idCap = rs.getInt(2);
                String name = rs.getString(3);
                return new Ship(idShip, idCaptain, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setStatusEmptyToPier(int idShip) {
        String request = "UPDATE PIERS SET STATUS = 'EMPTY', ID_SHIP = NULL WHERE ID_SHIP = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, idShip);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setStatusOccupiedToPier(int idShip, int idPier) {
        String request = "UPDATE PIERS SET STATUS = 'OCCUPIED', ID_SHIP = ? WHERE ID_PIER = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, idShip);
            preparedStatement.setInt(2, idPier);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void setCanceledStatusInRequestsTable(Connection connection, int request) {
        String updateRequest = "UPDATE REQUESTS SET STATUS = 'CANCELED' WHERE ID_REQUEST = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateRequest);
            //preparedStatement.setString(1,request.getRequestStatus().name());
            preparedStatement.setInt(1, request);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
