package ru.rsreu.datalayer.DAO;


public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract UsersDAO getUserDAO();
	public abstract AdminActionDAO getAdminActionDAO();

	public abstract CaptainActionDAO getCaptainActionDAO();


}
