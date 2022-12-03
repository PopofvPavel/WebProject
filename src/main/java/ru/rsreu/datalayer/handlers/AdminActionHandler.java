package ru.rsreu.datalayer.handlers;

import ru.rsreu.datalayer.DAO.*;
import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;
import ru.rsreu.datalayer.data.Worker;

import java.util.List;

public class AdminActionHandler {
    public static String getUsersTable() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();

        return usersTable.toString();
    }

    public static List<User> getUsersTableList() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UsersDAO usersDAO = factory.getUserDAO();
        List<User> usersTable = usersDAO.getRequest();

        return usersTable;
    }

    public static List<Worker> getWorkerTableList() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        WorkersDAO workersDAO = factory.getWorkersDAO();
        List<Worker> workersTable = workersDAO.getRequest();

        return workersTable;
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

    public static void registerNewWorker(Worker worker) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdminActionDAO adminActionDAO = factory.getAdminActionDAO();
        adminActionDAO.registerNewWorker(worker);
    }
}
