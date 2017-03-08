package Util.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08/03/17.
 */
public class RegistrationValidator extends Validator{

    private static final String NAME_SURNAME_REGEX = "^[а-яА-ЯёЁa-zA-Z]+$";
    private static final String LOGIN_REGEX = "^[a-z0-9_-]{3,16}$";
    private static final String PASSWORD_REGEX = "(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))" +
            "(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    private static final String EMAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+" +
            "(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String PHONE_REGEX = "^\\d{2}\\d{3}\\d{3}\\d{2}\\d{2}$";
    private static final String DATE_REGEX = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01]";


    private static final String EMAIL_ERROR = "Неправильно введен email";
    private static final String NAME_ERROR = "Неправильно введенно имя";
    private static final String SURNAME_ERROR = "Неправильно введенно фамилия";
    private static final String PHONE_ERROR = "Неправильно введен телефон (Пример ввода: 380930000000)";
    private static final String LOGIN_ERROR = "Пороль от 3 до 16 символов без спец символов";
    private static final String PASSWORD_ERROR = "Строчные и прописные латинские буквы, цифры, спецсимволы. Минимум 6 символов";
    private static final String DATE_ERROR = "Неправильно введенна дата, формат ввода гггг-мм-дд";

    public RegistrationValidator() {
        errorMsg = new ArrayList<String>();
    }

    @Override
    public void validRequest(HttpServletRequest request) throws IOException, ServletException {
        validLogin(request);
        validPassword(request);
        validEmail(request);
        validName(request);
        validSurname(request);
        validDate(request);
        validPhone(request);
    }

    private void validName(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (!name.matches(NAME_SURNAME_REGEX)) {
            errorMsg.add(NAME_ERROR);
        }
    }

    private void validSurname(HttpServletRequest request) {
        String surname = request.getParameter("surname");
        if (!surname.matches(NAME_SURNAME_REGEX)) {
            errorMsg.add(SURNAME_ERROR);
        }
    }

    private void validLogin(HttpServletRequest request) {
        String login = request.getParameter("login");
        if (!login.matches(LOGIN_REGEX)) {
            errorMsg.add(LOGIN_ERROR);
        }
    }

    private void validPassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        if (!password.matches(PASSWORD_REGEX)) {
            errorMsg.add(PASSWORD_ERROR);
        }
    }

    private void validEmail(HttpServletRequest request) {
        String email = request.getParameter("email");
        if (!email.matches(EMAIL_REGEX)) {
            errorMsg.add(EMAIL_ERROR);
        }
    }

    private void validPhone(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        if (!phone.matches(PHONE_REGEX)) {
            errorMsg.add(PHONE_ERROR);
        }
    }

    private void validDate(HttpServletRequest request) {
        String date = request.getParameter("date");
        if (!date.matches(DATE_REGEX)) {
            errorMsg.add(DATE_ERROR);
        }
    }
}
