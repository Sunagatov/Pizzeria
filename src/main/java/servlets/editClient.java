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
@WebServlet("/editClient")
public class EditClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int clientID = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String patronymic = request.getParameter("patronymic");
            String telephoneNumber = request.getParameter("telephoneNumber");
            //Получаем инфо об ошибке
            String error = checkTaskData(name, surname, patronymic, telephoneNumber);
            //Если ошибки нет,то обновляем инфу о клиенте
            if (error == null) {
                DAO.getInstance().updateClient(clientID, name, surname, patronymic, Integer.parseInt(request.getParameter("telephoneNumber")));
                response.sendRedirect("clients.jsp");
            } else {
                request.getSession().setAttribute("error", error);
                response.sendRedirect("editClient.jsp" + "?id=" + clientID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private String checkTaskData(String name, String surname, String patronymic, String telephoneNumber) {
        String errorMessage = null;
        if (name.isEmpty() || surname.isEmpty() || patronymic.isEmpty() || telephoneNumber.isEmpty()) {
            errorMessage = "Ошибка! Пустые поля!";
        }
        try{
            Integer.parseInt(telephoneNumber); }
        catch (Exception e) {
            errorMessage = "Ошибка! Неправильно введен номер телефона!";
        }
        return errorMessage;
    }
}