package ru.rsreu.datalayer.handlers;

import ru.rsreu.datalayer.DAO.CaptainActionDAO;
import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.data.Request;

public class CaptainActionHandler {
    public static void sendRequest(Request request) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CaptainActionDAO captainActionDAO = factory.getCaptainActionDAO();
        captainActionDAO.sendRequest(request);
    }
}
