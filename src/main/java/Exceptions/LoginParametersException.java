package Exceptions;

/**
 * Created by root on 04/03/17.
 */
public class LoginParametersException extends RuntimeException {

    public LoginParametersException() {}

    public LoginParametersException(String message) {
        super(message);
    }

    public LoginParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginParametersException(Throwable cause) {
        super(cause);
    }
}
