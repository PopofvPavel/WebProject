package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface WorkersDAO {
     List<Worker> getAllWorkersList();

     void insertWorker(Worker worker);

     Worker getWorkerById(int id);

     Worker getWorkerById(String id);

     void deleteWorker(Worker worker);

     void updateWorker(Worker worker);

     Worker getWorkerFromResultSet(ResultSet resultSet) throws SQLException;


}
