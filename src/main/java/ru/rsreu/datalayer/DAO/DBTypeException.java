package ru.rsreu.datalayer.DAO;

public class DBTypeException extends RuntimeException {
	public DBTypeException() {
		super();
	}

	public DBTypeException(String message) {
		super(message);
	}
}
