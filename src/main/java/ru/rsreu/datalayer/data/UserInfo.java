package ru.rsreu.datalayer.data;

/**
 * user info
 */
public class UserInfo {
    private int idUser;
    private String login;
    private String password;
    private boolean isAuthorized;
    /**
     * constructor
      */
    private boolean isBlocked;

    public UserInfo(int idUser, String login, String password, boolean isAuthorized, boolean isBlocked) {
        this.idUser = idUser;
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
     * id user setter
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
     * tostring
     * @return
     */
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
