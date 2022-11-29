package ru.rsreu.datalayer.data;

public class User {
    private int idUser;
    private  int idUserType;
    private  String login;
    private String password;
    private int isAuthorized;
    private int isBlocked;

    public User(int idUser, int idUserType, String login, String password, int isAuthorized, int isBlocked) {
        this.idUser = idUser;
        this.idUserType = idUserType;
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

    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
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

    public int isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(int authorized) {
        isAuthorized = authorized;
    }

    public int isBlocked() {
        return isBlocked;
    }

    public void setBlocked(int blocked) {
        isBlocked = blocked;
    }

    public static String getUserTableHeader() {
        return String.format("%-12s%-17s%-17s%-17s%-17s%-17s\n", "ID_USER", "ID_USER_TYPE", "LOGIN","PASSWORD","IS_AUTHORIZED","IS_BLOCKED");
    }
    @Override
    public String toString() {
        return String.format("%-12d%-17d%-17s%-17s%-17d%-17d\n", idUser,idUserType, login, password, isAuthorized, isBlocked);
    }
}
