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
@WebServlet("/deletePizzaMaker")
public class DeletePizzaMaker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pizzaMakerID = Integer.parseInt(request.getParameter("id"));
        try {
            DAO.getInstance().deletePizzaMaker(pizzaMakerID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("PizzaMakers.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
