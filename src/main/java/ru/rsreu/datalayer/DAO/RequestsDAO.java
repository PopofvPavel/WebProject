package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;

import java.util.List;

/**
 * DAO for requests
 */
public interface RequestsDAO {
    /**
     * gets las request by id
     * @param idCaptain
     * @return
     */
    Request getLastRequestById(int idCaptain);

    /**
     * gets all requests
     * @return
     */
    List<Request> getAllRequests();

    /**
     * sets request status
     * @param request
     * @param status
     */
    void setRequestStatus(Request request, RequestStatus status);

    /**
     * sets request status by request id
     * @param idRequest
     * @param status
     */
    void setRequestStatus(int idRequest, RequestStatus status);

}
