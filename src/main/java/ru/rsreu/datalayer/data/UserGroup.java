package ru.rsreu.datalayer.data;

/**
 * user group
 */
public class UserGroup {
    private int idUserType;
    private UserType userType;

    /**
     * constructor
     * @param idUserType
     * @param userType
     */
    public UserGroup(int idUserType, UserType userType) {
        this.idUserType = idUserType;
        this.userType = userType;
    }

    /**
     * user type getter
     * @return
     */
    public int getIdUserType() {
        return idUserType;
    }


    /**
     * tostring
     * @return
     */
    @Override
    public String toString() {
        return "UserGroup{" +
                "idUserType=" + idUserType +
                ", userType=" + userType +
                '}';
    }
}
