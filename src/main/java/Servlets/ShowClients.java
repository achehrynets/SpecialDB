package Servlets;

import DAO.ClientDAOImpl;
import DAO.DAOInterfaces.ClientDAO;
import Entity.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by root on 23/02/17.
 */
@WebServlet(
        name = "clientOrders",
        urlPatterns = "/clientorders"
)
public class ShowClients extends HttpServlet {
    ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        clientDAO = new ClientDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("/WEB-INF/admin/clientOrders.jsp");
        //request.getRequestDispatcher("/WEB-INF/admin/clientOrders.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listClients", clientDAO.getAllClient());
        for (Client cl: clientDAO.getAllClient()) {
            System.out.println(cl.getClient_id() + "  " + cl.getLogin());
        }
        request.getRequestDispatcher("/WEB-INF/admin/clientsOrders.jsp").forward(request, response);
    }
}
