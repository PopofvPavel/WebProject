package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.User;
import ru.rsreu.datalayer.data.UserInfo;
import ru.rsreu.datalayer.data.Worker;

import java.util.List;

/**
 * DAO for admin action
 */
public interface AdminActionDAO {
    /**
     * returns user info table
     * @return
     */
    List<UserInfo> getUsersInfoTable();

    /**
     * registers new user
     * @param user
     */
    void registerNewUser(User user);

    /**
     * registers new worker
     * @param worker
     */

    void registerNewWorker(Worker worker);

}
