package ru.rsreu.datalayer.handlers;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;

import java.util.List;

public class SystemHandler {
    public static boolean isValidLogin(String login) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();
        for (User user : usersTable) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }

        return true;
    }
    public static boolean isValidPassword(String password) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();
        for (User user : usersTable) {
            if (user.getPassword().equals(password)) {
                return false;
            }
        }

        return true;
    }

    public static int getNewUserId() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();
        int usersAmount = usersTable.size();
        int newUserId = ++usersAmount;
        System.out.println("users amount = " + usersAmount);
        return newUserId;


    }
}
