package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.AdminActionDAO;
import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;
import ru.rsreu.datalayer.data.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleAdminActionDAO implements AdminActionDAO {
    private Connection connection;

    public OracleAdminActionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UserInfo> getUsersInfoTable() {
        List<UserInfo> list = new ArrayList<UserInfo>();
        String request = "SELECT ID_USER,LOGIN,PASSWORD, IS_AUTHORIZED, IS_BLOCKED FROM USER_GROUPS JOIN USERS ON USER_GROUPS.ID_USER_TYPE = USERS.ID_USER_TYPE";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);

            while ((rs.next())) {
                int idUser = rs.getInt(1);
                String login = rs.getString(2);
                String password = rs.getString(3);
                boolean isAuthorized = (rs.getInt(4)) == 1;
                boolean isBlocked = rs.getInt(5) == 1;

                list.add(new UserInfo(idUser, login, password, isAuthorized, isBlocked));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void registerNewUser(User user) {
        String insertRequest = "INSERT INTO USERS VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertRequest);
            preparedStatement.setInt(1,user.getIdUser());
            preparedStatement.setInt(2, user.getIdUserType());
            preparedStatement.setString(3,user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.isAuthorized());
            preparedStatement.setInt(6, user.isBlocked());

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

    @Override
    public void registerNewWorker(Worker worker) {
        String insertRequest = "INSERT INTO WORKERS VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertRequest);
            preparedStatement.setInt(1,worker.getIdWorker());
            preparedStatement.setString(2, worker.getPost().name());
            preparedStatement.setString(3,worker.getFIO());

            preparedStatement.executeUpdate();
            System.out.println("inserted new worker");
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
