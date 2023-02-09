package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.RequestInfo;

import java.util.List;

/**
 * DAO for request info
 */
public interface RequestsInfoDAO {
    /**
     * returns request info
     * @return
     */
    List<RequestInfo> getRequest();
}
