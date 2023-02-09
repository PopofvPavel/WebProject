package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import java.sql.*;
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
            System.out.println("User table executed");
            while (rs.next()) {
                System.out.print("Row1: ");
                list.add(getUserFromResultSet(rs));
                System.out.println(getUserFromResultSet(rs));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public User getUserById(int id) {
        String request = "SELECT * FROM USERS WHERE ID_USER = ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = getUserFromResultSet(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUserById(String id) {
        return getUserById(Integer.parseInt(id));
    }

    @Override
    public User getUserByLogin(String login) {
        String request = "SELECT * FROM USERS WHERE LOGIN = ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = getUserFromResultSet(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateUser(User user) {
        String request = "UPDATE USERS SET ID_USER_TYPE = ?, LOGIN = ?, PASSWORD = ?, IS_AUTHORIZED = ?, IS_BLOCKED  = ? WHERE ID_USER = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, user.getIdUserType());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4,user.isAuthorized());
            preparedStatement.setInt(5, user.isBlocked());
            preparedStatement.setInt(6, user.getIdUser());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        String request = "DELETE FROM USERS WHERE ID_USER = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, user.getIdUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        int idUser = resultSet.getInt(1);
        int idUserType = resultSet.getInt(2);
        String login = resultSet.getString(3);
        String password = resultSet.getString(4);
        int isAuthorized = resultSet.getInt(5);
        int isBlocked = resultSet.getInt(6);

        return new User(idUser, idUserType, login, password, isAuthorized, isBlocked);
    }

    @Override
    public void insertUser(User user) {
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
}
