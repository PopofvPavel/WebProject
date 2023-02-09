package ru.rsreu.datalayer.data;

/**
 * info about request used for table
 */
public class RequestInfo {
    private int idRequest;
    private RequestType requestType;
    private RequestStatus requestStatus;
    private int idCaptain;
    private Post post;
    private String FIO;

    /**
     * Constructor
     * @param idRequest
     * @param requestType
     * @param requestStatus
     * @param idCaptain
     * @param post
     * @param FIO
     */
    public RequestInfo(int idRequest, RequestType requestType, RequestStatus requestStatus, int idCaptain, Post post, String FIO) {
        this.idRequest = idRequest;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.idCaptain = idCaptain;
        this.post = post;
        this.FIO = FIO;
    }

    /**
     * id getter
     * @return
     */
    public int getIdRequest() {
        return idRequest;
    }

    /**
     * id setter
     * @param idRequest
     */
    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    /**
     * type getter
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
     * request type getter
     * @return
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * status setter
     * @param requestStatus
     */
    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * id captein getter
     * @return
     */
    public int getIdCaptain() {
        return idCaptain;
    }

    /**
     * is captain setter
     * @param idCaptain
     */
    public void setIdCaptain(int idCaptain) {
        this.idCaptain = idCaptain;
    }

    /**
     * post getter
     * @return
     */
    public Post getPost() {
        return post;
    }

    /**
     * post setter
     * @param post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * FIO getter
     * @return
     */
    public String getFIO() {
        return FIO;
    }

    /**
     * FIO setter
     * @param FIO
     */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    /**
     * tostring
     * @return
     */
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
