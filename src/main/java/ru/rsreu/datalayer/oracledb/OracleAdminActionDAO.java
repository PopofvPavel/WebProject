package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.*;
import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;
import ru.rsreu.datalayer.data.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        usersDAO.insertUser(user);

    }

    @Override
    public void registerNewWorker(Worker worker) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        WorkersDAO workersDAO = factory.getWorkersDAO();
        workersDAO.insertWorker(worker);
    }
}
