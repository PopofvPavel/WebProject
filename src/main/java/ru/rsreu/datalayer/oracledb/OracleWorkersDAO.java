package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.WorkersDAO;
import ru.rsreu.datalayer.data.Post;
import ru.rsreu.datalayer.data.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleWorkersDAO implements WorkersDAO {
    private Connection connection;

    public OracleWorkersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Worker> getRequest() {
        List<Worker> list = new ArrayList<Worker>();
        String request = "SELECT * FROM WORKERS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                int idWorker = rs.getInt(1);
                String post = rs.getString(2);
                String fio = rs.getString(3);
                System.out.println("WORKERS " + idWorker + post + fio );

                list.add(new Worker(idWorker, Post.valueOf(post.toUpperCase()),fio));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
