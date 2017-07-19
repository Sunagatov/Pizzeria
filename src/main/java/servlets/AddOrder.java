package servlets;

import models.Client;
import models.Order;
import models.Pizza;
import models.PizzaMaker;
import utils.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Zufar on 15-Jul-17.
 */
@WebServlet("/addOrder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String idClient = request.getParameter("clientID");
        String idPizzaMaker = request.getParameter("pizzaMakerID");
        String idPizza = request.getParameter("pizzaID");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
           //Получаем инфо об ошибке
            String error = checkTaskData(startDate, endDate);
            //Если ошибки нет,то обновляем инфу о клиенте
            if (error == null) {
                LocalDateTime start = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
                LocalDateTime end = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
                int idClientINT = Integer.parseInt(idClient);
                int idPizzaINT = Integer.parseInt(idPizza);
                int idPizzaMakerINT = Integer.parseInt(idPizzaMaker);
                DAO.getInstance().storeOrder(idClientINT, idPizzaINT, idPizzaMakerINT, start, end, Order.Status.START);
                response.sendRedirect("index.jsp");
            } else {
                request.getSession().setAttribute("error", error);
                response.sendRedirect("AddOrder.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private String checkTaskData(String startDate, String endDate) {
        String errorMessage = null;
        if (startDate.isEmpty() || endDate.isEmpty()) {
            errorMessage = "Ошибка! Пустые поля!";
        }
        try {
            LocalDateTime start = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        } catch (Exception e) {
            errorMessage = "Ошибка! Неправильно введены даты!";
        }
        return errorMessage;
    }
}
