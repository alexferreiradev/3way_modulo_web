package data.dao.exception;

public class DAOException extends Exception {

	public DAOException() {
		this("Erro desconhecido no DAO");
	}

	public DAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DAOException(Throwable cause) {
		this("Erro desconhecido no DAO",cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
