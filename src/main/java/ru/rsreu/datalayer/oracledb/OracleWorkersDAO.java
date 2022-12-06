package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.WorkersDAO;
import ru.rsreu.datalayer.data.Post;
import ru.rsreu.datalayer.data.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleWorkersDAO implements WorkersDAO {
    private final Connection connection;

    public OracleWorkersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Worker> getAllWorkersList() {
        List<Worker> list = new ArrayList<>();
        String request = "SELECT * FROM WORKERS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                list.add(getWorkerFromResultSet(rs));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void insertWorker(Worker worker) {
        String insertRequest = "INSERT INTO WORKERS VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertRequest);
            preparedStatement.setInt(1, worker.getIdWorker());
            preparedStatement.setString(2, worker.getPost().name());
            preparedStatement.setString(3, worker.getFIO());

            preparedStatement.executeUpdate();
            System.out.println("inserted new worker");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Worker getWorkerById(int id) {
        String request = "SELECT * FROM WORKERS WHERE ID_WORKER = ?";
        Worker worker = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                worker = getWorkerFromResultSet(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return worker;
    }

    @Override
    public Worker getWorkerById(String id) {
        return this.getWorkerById(Integer.parseInt(id));
    }

    @Override
    public void deleteWorker(Worker worker) {
        String request = "DELETE FROM WORKERS WHERE ID_WORKER = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, worker.getIdWorker());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWorker(Worker worker) {//not checked
        String request = "UPDATE WORKERS SET POST = ?, FIO = ? WHERE ID_WORKER = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, worker.getPost().name());
            preparedStatement.setString(2, worker.getFIO());
            preparedStatement.setInt(3, worker.getIdWorker());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }

    }

    @Override
    public Worker getWorkerFromResultSet(ResultSet resultSet) throws SQLException {
        int idWorker = resultSet.getInt(1);
        String post = resultSet.getString(2);
        String fio = resultSet.getString(3);
        return new Worker(idWorker, Post.valueOf(post.toUpperCase()), fio);
    }
}
