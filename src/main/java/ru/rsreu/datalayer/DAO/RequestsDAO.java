package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Request;
import ru.rsreu.datalayer.data.RequestStatus;

import java.util.List;

public interface RequestsDAO {
    Request getLastRequestById(int idCaptain);

    List<Request> getAllRequests();

    void setRequestStatus(Request request, RequestStatus status);

    void setRequestStatus(int idRequest, RequestStatus status);







}
