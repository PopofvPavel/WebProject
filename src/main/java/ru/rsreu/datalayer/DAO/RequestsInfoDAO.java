package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.RequestInfo;

import java.util.List;

public interface RequestsInfoDAO {
    List<RequestInfo> getRequest();
}
