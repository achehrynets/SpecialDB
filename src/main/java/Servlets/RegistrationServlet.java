package Servlets;

import DAO.DAOInterfaces.ClientDAO;
import DAO.ClientDAOImpl;
import Entity.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by root on 20/02/17.
 */
@WebServlet("/")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = new Client();
        String name = request.getParameter("userName");
        String surname = request.getParameter("userSurname");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        client.setName(name);
        client.setSurname(surname);
        client.setBirthday(birthday);
        client.setLogin(login);
        client.setPassword(password);
        client.setEmail(email);
        client.setPhone(phone);
        client.setValid(false);
        client.setRole("client");
        client.toString();

        ClientDAO clientDAO = new ClientDAOImpl();
        clientDAO.createClient(client);
         response.sendRedirect("/Test.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Registration.jsp").forward(request,response);
    }
}
