package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.RequestsDAO;
import ru.rsreu.datalayer.data.RequestStatus;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRequestCommand extends Command {
   // private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private RequestsDAO requestsDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
         //requestsDAO = factory.getRequestsDAO();
        requestsDAO = (RequestsDAO) request.getServletContext().getAttribute("requestsDAO");

    }

    @Override
    public void send() {
        String id = request.getParameter("idReq");
        String type = request.getParameter("update-type");
        requestsDAO.setRequestStatus(Integer.parseInt(id), RequestStatus.valueOf(type));

        try {
            forward("/update-request-status.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(id );
        System.out.println("type = " + type);
    }
}
