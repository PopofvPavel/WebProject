package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    List<User> getRequest();

    User getUserById(int id);

    User getUserById(String id);

    User getUserByLogin(String login);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserFromResultSet(ResultSet resultSet) throws SQLException;

    void insertUser(User user);


}
