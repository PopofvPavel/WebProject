package ru.rsreu.datalayer.handlers;

import ru.rsreu.datalayer.DAO.AdminActionDAO;
import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.UsersDAO;
import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;

import java.util.List;

public class AdminActionHandler {
    public static String getUsersTable() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();

        return usersTable.toString();
    }

    public static String getUsersInfoTable() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdminActionDAO adminActionDAO = factory.getAdminActionDAO();
        List<UserInfo> usersInfoTable = adminActionDAO.getUsersInfoTable();

        return usersInfoTable.toString();
    }

    public static void registerNewUser(User user) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdminActionDAO adminActionDAO = factory.getAdminActionDAO();
        adminActionDAO.registerNewUser(user);
    }
}
