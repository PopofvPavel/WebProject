package ru.rsreu.datalayer.data;

public class RequestInfo {
    private int idRequest;
    private RequestType requestType;
    private RequestStatus requestStatus;
    private int idCaptain;
    private Post post;
    private String FIO;

    public RequestInfo(int idRequest, RequestType requestType, RequestStatus requestStatus, int idCaptain, Post post, String FIO) {
        this.idRequest = idRequest;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.idCaptain = idCaptain;
        this.post = post;
        this.FIO = FIO;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "idRequest=" + idRequest +
                ", requestType=" + requestType +
                ", requestStatus=" + requestStatus +
                ", idCaptain=" + idCaptain +
                ", post=" + post +
                ", FIO='" + FIO + '\'' +
                '}';
    }
}
