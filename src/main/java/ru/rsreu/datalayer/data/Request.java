package ru.rsreu.datalayer.data;

public class Request {
    private int idRequest;
    private RequestType requestType;
    private RequestStatus requestStatus;
    private int idCaptain;

    public Request(int idRequest, RequestType requestType, RequestStatus requestStatus, int idCaptain) {
        this.idRequest = idRequest;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.idCaptain = idCaptain;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public int getIdCaptain() {
        return idCaptain;
    }

    public void setIdCaptain(int idCaptain) {
        this.idCaptain = idCaptain;
    }

    @Override
    public String toString() {
        return "Request{" +
                "idRequest=" + idRequest +
                ", requestType=" + requestType +
                ", requestStatus=" + requestStatus +
                ",id caprain = " + idCaptain +
                "}";
    }
}
