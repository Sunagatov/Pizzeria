package servlets;

import models.PizzaMaker;
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
@WebServlet("/editPizzaMaker")
public class EditPizzaMaker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int pizzaMakerID = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String patronymic = request.getParameter("patronymic");
            String hourlyPay = request.getParameter("hourlyPay");
            //Получаем инфо об ошибке
            String error = checkTaskData(name, surname, patronymic, hourlyPay);
            //Если ошибки нет,то обновляем инфу о клиенте
            if (error == null) {
                DAO.getInstance().updatePizzaMaker(pizzaMakerID, name, surname, patronymic, Integer.parseInt(request.getParameter("hourlyPay")));
                response.sendRedirect("PizzaMakers.jsp");
            } else {
                request.getSession().setAttribute("error", error);
                response.sendRedirect("EditPizzaMaker.jsp" + "?id=" + pizzaMakerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private String checkTaskData(String name, String surname, String patronymic, String hourlyPay) {
        String errorMessage = null;
        if (name.isEmpty() || surname.isEmpty() || patronymic.isEmpty() || hourlyPay.isEmpty()) {
            errorMessage = "Ошибка! Пустые поля!";
        }
        try{
            Integer.parseInt(hourlyPay); }
        catch (Exception e) {
            errorMessage = "Ошибка! Неправильно введена почасовая оплата!";
        }
        return errorMessage;
    }
}
