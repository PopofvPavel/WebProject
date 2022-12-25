package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.RequestsDAO;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;
import ru.rsreu.datalayer.data.RequestType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleRequestsDAO implements RequestsDAO {
    private final Connection connection;

    public OracleRequestsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Request getLastRequestById(int idCaptain) {
        List<Request> list = this.getAllRequests();
        Request returnRequest = null;
        for (Request request : list) {
            if (request.getIdCaptain() == idCaptain) {
                returnRequest = request;
            }
        }
        return returnRequest;
    }

    @Override
    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<>();
        String request = "SELECT * FROM REQUESTS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            System.out.println("gg");
            while (rs.next()) {
                int idRequest = rs.getInt(1);
                RequestType type = RequestType.valueOf(rs.getString(2));
                RequestStatus status = RequestStatus.valueOf(rs.getString(3));
                int idCaptain = rs.getInt(4);

                list.add(new Request(idRequest,type,status,idCaptain));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public void setRequestStatus(Request request, RequestStatus status) {
        setRequestStatus(request.getIdRequest(),status);
    }

    @Override
    public void setRequestStatus(int idRequest, RequestStatus status) {
        String request = "UPDATE REQUESTS SET STATUS = ? WHERE ID_REQUEST = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, status.name());
            preparedStatement.setInt(2, idRequest);

            preparedStatement.executeUpdate();
            System.out.println("UPDATED STATUS: " + status.name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
