package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;
import ru.rsreu.datalayer.data.Worker;

import java.util.List;

public interface AdminActionDAO {
    List<UserInfo> getUsersInfoTable();

    void registerNewUser(User user);

    void registerNewWorker(Worker worker);

}
