package servlets;

import utils.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Zufar on 15-Jul-17.
 */
@WebServlet("/deleteClient")
public class DeleteClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientID = Integer.parseInt(request.getParameter("id"));
        try {
            DAO.getInstance().deleteClient(clientID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("Clients.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
