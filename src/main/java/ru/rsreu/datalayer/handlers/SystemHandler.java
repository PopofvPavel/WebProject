package ru.rsreu.datalayer.handlers;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.RequestsDAO;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();
        for (User user : usersTable) {
            if (user.getPassword().equals(password)) {
                return false;
            }
        }

        return true;*/
        return !(password.isEmpty());
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

    public static int getNewRequestId() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestsDAO requestDAO = factory.getRequestsDAO();
        List<Request> requestsTable = requestDAO.getAllRequests();
        int requestsAmount = requestsTable.size();
        int newRequestId = ++requestsAmount;

        return newRequestId;
    }


    public static boolean isValidUserId(int userId) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();
        Map<Integer, Integer> usersMap = new HashMap<>();
        for (User user : usersTable) {
            usersMap.put(user.getIdUser(), user.getIdUserType());
        }
        boolean isValidIdUser = usersMap.containsKey(userId) && usersMap.get(userId).equals(3);
        System.out.println("all ids" + usersMap);
        return isValidIdUser;
    }
}
