package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO for user
 */
public interface UsersDAO {
    /**
     * returns user table
     * @return
     */
    List<User> getRequest();

    /**
     * returns user by id
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * returns user by id (string)
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * returns user by login
     * @param login
     * @return
     */
    User getUserByLogin(String login);

    /**
     * updates user
     * @param user
     */
    void updateUser(User user);

    /**
     * deletes user
     * @param user
     */
    void deleteUser(User user);

    /**
     * gets user from result set
     * @param resultSet
     * @return
     * @throws SQLException
     */
    User getUserFromResultSet(ResultSet resultSet) throws SQLException;

    /**
     * inserts user
     * @param user
     */
    void insertUser(User user);


}
