package ru.rsreu.datalayer.data;

public class UserGroup {
    private int idUserType;
    private UserType userType;

    public UserGroup(int idUserType, UserType userType) {
        this.idUserType = idUserType;
        this.userType = userType;
    }

    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "idUserType=" + idUserType +
                ", userType=" + userType +
                '}';
    }
}
