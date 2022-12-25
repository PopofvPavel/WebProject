package ru.rsreu.control.commands;

import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;
import ru.rsreu.datalayer.data.RequestType;
import ru.rsreu.datalayer.handlers.CaptainActionHandler;
import ru.rsreu.datalayer.handlers.SystemHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendRequestCommand extends Command {
    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);

    }

    @Override
    public void send() {
        boolean isArrivalRequest = request.getParameter("request-type").equals("arrival");
        int idRequest = SystemHandler.getNewRequestId();
        RequestType requestType = isArrivalRequest ? RequestType.ARRIVAL : RequestType.DEPARTURE;
        RequestStatus requestStatus = RequestStatus.IN_CONSIDERATON;
        //int idCaptain = 6;    //fix later
        int idCaptain = (int)request.getSession().getAttribute("idUser");
        Request requestCap = new Request(idRequest, requestType, requestStatus, idCaptain);
        boolean isSendRequest = CaptainActionHandler.sendRequest(requestCap);
        try {
            if (isSendRequest) {
                this.forward("/new-request.jsp");

            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
