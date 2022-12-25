package ru.rsreu.datalayer.handlers;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.RequestsDAO;
import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;

import java.util.List;

public class DispatcherActionHandler {
    public static List<Request> getAllRequestsList() {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestsDAO requestsDAO = factory.getRequestsDAO();

        return requestsDAO.getAllRequests();
    }

    public static void setRequestStatus(Request request, RequestStatus status) {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestsDAO requestsDAO = factory.getRequestsDAO();

        requestsDAO.getAllRequests();

    }

}
