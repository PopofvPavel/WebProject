package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.CaptainActionDAO;
import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.Ship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleCaptainActionDAO implements CaptainActionDAO {
    private final Connection connection;

    public OracleCaptainActionDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void sendRequest(Request request) {
        String insertRequest = "INSERT INTO REQUESTS VALUES (?,?,?,?)";
        try {
            System.out.println(request.getRequestType().name() + '\n' + request.getRequestStatus().name());
            PreparedStatement preparedStatement = connection.prepareStatement(insertRequest);
            preparedStatement.setInt(1,request.getIdRequest());
            preparedStatement.setString(2, request.getRequestType().name());
            preparedStatement.setString(3,request.getRequestStatus().name());
            preparedStatement.setInt(4, request.getIdCaptain());

            preparedStatement.executeUpdate();
            System.out.println("inserted captain request");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
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

    private void setStatusEmptyToPier(int idShip) {
        String request = "UPDATE PIERS SET STATUS = 'EMPTY', ID_SHIP = NULL WHERE ID_SHIP = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1,idShip);
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
            preparedStatement.setInt(1,idShip);
            preparedStatement.setInt(2, idPier);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void setCanceledStatusInRequestsTable(Connection connection, int request) {
        String updateRequest = "UPDATE REQUESTS SET STATUS = 'CANCELED' WHERE ID_REQUEST = ?" ;

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
