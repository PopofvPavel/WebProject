package ru.rsreu.datalayer.oracledb;

import ru.rsreu.datalayer.DAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;


public class OracleDBDAOFactory extends DAOFactory {
	private static volatile OracleDBDAOFactory instance;
	private Connection connection;

	private OracleDBDAOFactory() {
	}

	public static OracleDBDAOFactory getInstance()
			throws ClassNotFoundException, SQLException {
		OracleDBDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDBDAOFactory.class) {
				instance = factory = new OracleDBDAOFactory();
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		//String url = "jdbc:oracle:thin:@localhost:1521:XE"; String url = "jdbc:oracle:thin:@localhost:1521/XE";
		String url = "jdbc:oracle:thin:SYS//@localhost:1521/orcl";
		String user = "SYS AS SYSDBA";
		String password = "2187";
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to oracle DB!");
	}

	@Override
	public UsersDAO getUserDAO() {
		return new OracleUsersDao(connection);
	}

	@Override
	public WorkersDAO getWorkersDAO() {
		return new OracleWorkersDAO(connection);
	}

	@Override
	public PiersDAO getPiersDAO() {
		return new OraclePiersDAO(connection);
	}

	@Override
	public AdminActionDAO getAdminActionDAO() {
		return new OracleAdminActionDAO(connection);
	}

	@Override
	public CaptainActionDAO getCaptainActionDAO() {
		return new OracleCaptainActionDAO(connection);


	}
}
