package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.PiersDAO;
import ru.rsreu.datalayer.data.Pier;
import ru.rsreu.datalayer.data.PierStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OraclePiersDAO implements PiersDAO {
    private Connection connection;

    public OraclePiersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pier> getRequest() {
        List<Pier> list = new ArrayList<Pier>();
        String request = "SELECT * FROM PIERS";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                int idPier = rs.getInt(1);
                PierStatus status = PierStatus.valueOf(rs.getString(2));
                Object idShipOb = rs.getString(3);
                Integer idShip = null;
                if (idShipOb != null) {
                    idShip = Integer.valueOf((String) idShipOb);
                }

           /*     Integer idShip = Integer.valueOf(rs.getString(3));*/
                System.out.println("PIERS " + idPier + status + idShip );

                list.add(new Pier(idPier,status,idShip));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
