package ru.rsreu.datalayer.DAO;

import ru.rsreu.datalayer.data.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO for workers
 */
public interface WorkersDAO {
     /**
      * returns alla worker talbe
      * @return
      */
     List<Worker> getAllWorkersList();

     /**
      * inserts worker
      * @param worker
      */
     void insertWorker(Worker worker);

     /**
      * gets worker by id
      * @param id
      * @return
      */
     Worker getWorkerById(int id);

     /**
      * gets worker by id
      * @param id
      * @return
      */
     Worker getWorkerById(String id);

     /**
      * deletes worker
      * @param worker
      */
     void deleteWorker(Worker worker);

     /**
      * updates worker
      * @param worker
      */
     void updateWorker(Worker worker);

     /**
      * gets worker from result set
      * @param resultSet
      * @return
      * @throws SQLException
      */
     Worker getWorkerFromResultSet(ResultSet resultSet) throws SQLException;


}
