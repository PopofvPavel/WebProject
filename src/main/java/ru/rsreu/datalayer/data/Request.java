package ru.rsreu.datalayer.data;

/**
 * Request of captain
 */
public class Request {
    private int idRequest;
    private RequestType requestType;
    private RequestStatus requestStatus;
    private int idCaptain;

    /**
     * Constructor
     * @param idRequest
     * @param requestType
     * @param requestStatus
     * @param idCaptain
     */
    public Request(int idRequest, RequestType requestType, RequestStatus requestStatus, int idCaptain) {
        this.idRequest = idRequest;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.idCaptain = idCaptain;
    }

    /**
     * request id getter
     * @return
     */
    public int getIdRequest() {
        return idRequest;
    }

    /**
     * request id setter
     * @param idRequest
     */
    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    /**
     * request type getter
     * @return
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * request type setter
     * @param requestType
     */
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * request status getter
     * @return
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * request status setter
     * @param requestStatus
     */
    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * id captain getter
     * @return
     */
    public int getIdCaptain() {
        return idCaptain;
    }

    /**
     * id captain setter
     * @param idCaptain
     */
    public void setIdCaptain(int idCaptain) {
        this.idCaptain = idCaptain;
    }

    /**
     * toString
     * @return
     */
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
