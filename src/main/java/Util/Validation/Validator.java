package Util.Validation;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by root on 08/03/17.
 */
public abstract class Validator {

    protected List<String> errorMsg;

    public boolean IsValid() {
        return errorMsg.isEmpty();
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public abstract void validRequest(HttpServletRequest request) throws IOException, ServletException;

}
