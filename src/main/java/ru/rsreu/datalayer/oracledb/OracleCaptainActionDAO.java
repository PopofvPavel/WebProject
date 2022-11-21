package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.CaptainActionDAO;
import ru.rsreu.datalayer.data.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleCaptainActionDAO implements CaptainActionDAO {
    private Connection connection;

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
}
