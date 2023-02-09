package ru.rsreu.datalayer.data;

/**
 * User of system
 */
public class User {
    private int idUser;
    private  int idUserType;
    private  String login;
    private String password;
    private int isAuthorized;
    private int isBlocked;

    /**
     * constructor
     * @param idUser
     * @param idUserType
     * @param login
     * @param password
     * @param isAuthorized
     * @param isBlocked
     */
    public User(int idUser, int idUserType, String login, String password, int isAuthorized, int isBlocked) {
        this.idUser = idUser;
        this.idUserType = idUserType;
        this.login = login;
        this.password = password;
        this.isAuthorized = isAuthorized;
        this.isBlocked = isBlocked;
    }

    /**
     * id user getter
     * @return
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * user id setter
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * user type getter
     * @return
     */
    public int getIdUserType() {
        return idUserType;
    }

    /**
     * login getter
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * login setter
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * password getter
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * password setter
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * check for authorization
     * @return
     */
    public int isAuthorized() {
        return isAuthorized;
    }

    /**
     * setter for authorization
     * @param authorized
     */
    public void setAuthorized(int authorized) {
        isAuthorized = authorized;
    }

    /**
     * check for ban
     * @return
     */
    public int isBlocked() {
        return isBlocked;
    }

    /**
     * ban
     * @param blocked
     */
    public void setBlocked(int blocked) {
        isBlocked = blocked;
    }

    /**
     * table header
     * @return
     */
    public static String getUserTableHeader() {
        return String.format("%-12s%-17s%-17s%-17s%-17s%-17s\n", "ID_USER", "ID_USER_TYPE", "LOGIN","PASSWORD","IS_AUTHORIZED","IS_BLOCKED");
    }

    /**
     * tostring
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-12d%-17d%-17s%-17s%-17d%-17d\n", idUser,idUserType, login, password, isAuthorized, isBlocked);
    }
}
