package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.*;
import ru.rsreu.datalayer.data.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TransmitCommand extends Command {
    private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private PiersDAO piersDAO;
    private RequestsDAO requestsDAO;
    private WorkersDAO workersDAO;
    private ShipsDAO shipsDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
        piersDAO = factory.getPiersDAO();
        requestsDAO = factory.getRequestsDAO();
        workersDAO = factory.getWorkersDAO();
        shipsDAO = factory.getShipsDAO();
    }

    @Override
    public void send() throws IOException {
        int emptyPiersCounter = getEmptyPiersCount();
        System.out.println("trans start");
        int idCaptain = (Integer) request.getSession().getAttribute("idUser");
        Request lastCapRequest = requestsDAO.getLastRequestById(idCaptain);
        RequestType requestType = lastCapRequest.getRequestType();
        if (requestType.equals(RequestType.ARRIVAL)) {

            if (emptyPiersCounter > 0) {
                Worker captain = workersDAO.getWorkerById(lastCapRequest.getIdCaptain());
                Ship ship = shipsDAO.getShipByCaptainId(captain.getIdWorker());
                boolean shipIsInPier = getShipIsInPier(ship);
                System.out.println("boolean ship is in pier(transmit com) = " + shipIsInPier);
                if (shipIsInPier) {
                    System.out.println("InshipisInPier method");
                    request.getSession().setAttribute("isShipTransmitted", false);
                    try {
                        forward("/transmitting-ship-status.jsp");
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                //lastCapRequest.setRequestStatus(RequestStatus.IN_WAITING);
                String id = String.valueOf(lastCapRequest.getIdRequest());
                String type = String.valueOf(RequestStatus.IN_WAITING);
                requestsDAO.setRequestStatus(Integer.parseInt(id), RequestStatus.valueOf(type));
                request.getSession().setAttribute("isShipTransmitted", true);

                System.out.println("Ship was traansmitted");
                try {
                    forward("/transmitting-ship-status.jsp");
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } else {
                request.getSession().setAttribute("isShipTransmitted", false);
                try {
                    forward("/transmitting-ship-status.jsp");
                } catch (ServletException e) {
                    e.printStackTrace();
                }

          /*      try {
                    throw new Exception("All piers are occupied");
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

            }

        } else {
            Worker captain = workersDAO.getWorkerById(lastCapRequest.getIdCaptain());
            Ship ship = shipsDAO.getShipByCaptainId(captain.getIdWorker());
            boolean shipIsInPier = getShipIsInPier(ship);
            if (shipIsInPier) {
                String id = String.valueOf(lastCapRequest.getIdRequest());
                String type = String.valueOf(RequestStatus.IN_WAITING);
                requestsDAO.setRequestStatus(Integer.parseInt(id), RequestStatus.valueOf(type));
                request.getSession().setAttribute("isShipTransmitted", true);
                try {
                    forward("/transmitting-ship-status.jsp");
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            } else {
                request.getSession().setAttribute("isShipTransmitted", false);
                try {
                    forward("/transmitting-ship-status.jsp");
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println("trans end");
    }
    private boolean getShipIsInPier(Ship ship) {
        List<Pier> piers = piersDAO.getAllPiersList();
        for (Pier pier : piers) {
            if ((pier.getIdShip() != null) && (ship.getIdShip() == pier.getIdShip())) {
                return true;
            }
        }
        return false;
    }

    private Pier getEmptyPier() {
        List<Pier> piers = piersDAO.getAllPiersList();
        for (Pier pier : piers) {
            if (pier.getStatus().equals(PierStatus.EMPTY)) {
                return pier;
            }
        }
        return null;
    }
    private int getEmptyPiersCount() {
        List<Pier> piers = piersDAO.getAllPiersList();
        int counter = 0;
        for (Pier pier : piers) {
            if (pier.getStatus().equals(PierStatus.EMPTY)) {
                ++counter;
            }
        }
        return counter;
    }
}
