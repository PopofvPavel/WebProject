package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.DAOFactory;
import ru.rsreu.datalayer.DAO.DBType;
import ru.rsreu.datalayer.DAO.RequestsDAO;
import ru.rsreu.datalayer.data.RequestStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRequestCommand extends Command {
    private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private RequestsDAO requestsDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
         requestsDAO = factory.getRequestsDAO();
    }

    @Override
    public void send() {
        String id = request.getParameter("idReq");
        String type = request.getParameter("update-type");
        requestsDAO.setRequestStatus(Integer.parseInt(id), RequestStatus.valueOf(type));

        System.out.println(id );
        System.out.println("type = " + type);
    }
}
