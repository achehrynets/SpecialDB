package Exceptions;

/**
 * Created by root on 08/03/17.
 */
public class ClientServiceException extends RuntimeException {
    public ClientServiceException() {
    }

    public ClientServiceException(String message) {
        super(message);
    }

    public ClientServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientServiceException(Throwable cause) {
        super(cause);
    }
}
