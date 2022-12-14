package jm.task.core.jdbc.dao;

public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 2102076276311052301L;

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
