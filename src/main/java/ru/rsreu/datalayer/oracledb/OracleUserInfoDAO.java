package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.UsersInfoDAO;
import ru.rsreu.datalayer.data.UserInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleUserInfoDAO implements UsersInfoDAO {
    private Connection connection;

    public OracleUserInfoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UserInfo> getRequest() {
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
}
