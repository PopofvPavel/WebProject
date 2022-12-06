package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.RequestsDAO;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;
import ru.rsreu.datalayer.data.RequestType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleRequestsDAO implements RequestsDAO {
    private Connection connection;

    public OracleRequestsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<Request>();
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


}
