package ru.rsreu.datalayer.data;

public class UserInfo {
    private int idUser;
    private String login;
    private String password;
    private boolean isAuthorized;
    private boolean isBlocked;

    public UserInfo(int idUser, String login, String password, boolean isAuthorized, boolean isBlocked) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.isAuthorized = isAuthorized;
        this.isBlocked = isBlocked;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
            this.isBlocked = isBlocked;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAuthorized=" + isAuthorized +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
