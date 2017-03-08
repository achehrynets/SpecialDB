package Servlets;

import DAO.ClientDAOImpl;
import DAO.DAOInterfaces.ClientDAO;
import Entity.Client;
import Exceptions.LoginParametersException;
import Services.ClientControllerImpl;
import Services.ServicesInterfaces.ClientController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 23/02/17.
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LogIn extends HttpServlet {
    private ClientController clientController;


    @Override
    public void init() throws ServletException {
        clientController = new ClientControllerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(login + " " + password);
        String errorMsg;

        if ("".equals(login) || "".equals(password)) {
            errorMsg = "Заполните все поля!";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        } else {
            try {
                Client client = clientController.login(login, password);
                if(client == null) {
                    errorMsg = "Логин или пороль не правильные!";
                    request.setAttribute("errorMsg", errorMsg);
                    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                } else {
                    String role = client.getRole();
                    request.getSession().setAttribute("client", client);
                    request.getSession().setAttribute("role", role);
                    if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("moder")) {
                        response.sendRedirect("/clientorders");
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                }
            } catch (LoginParametersException ex) {
                errorMsg = ex.getMessage();
                request.setAttribute("errorMsg", errorMsg);
                request.getRequestDispatcher("/login").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login");
    }
}
