package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleUsersDao implements UsersDAO {
    private Connection connection;

    public OracleUsersDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getRequest() {
        List<User> list = new ArrayList<User>();
        String request = "SELECT * FROM USERS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            System.out.println("gg");
            while (rs.next()) {
                int idUser = rs.getInt(1);
                int idUserType = rs.getInt(2);
                String login = rs.getString(3);
                String password = rs.getString(4);
                int isAuthorized = rs.getInt(5);
                int isBlocked = rs.getInt(6);
                System.out.println("GET^ " + idUser + idUserType + login + password + isAuthorized + isBlocked);

                list.add(new User(idUser, idUserType, login, password, isAuthorized, isBlocked));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
