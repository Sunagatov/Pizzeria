<%@ page import="utils.DAO" %>
<%@ page import="models.PizzaMaker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = null;
    try {
        error = (String) request.getSession().getAttribute("error");
        if (error != null) {
            request.getSession().removeAttribute("error");
        }
    } catch (Exception e) {
    }
    PizzaMaker pizzaMaker = null;
    int id = Integer.parseInt(request.getParameter("id"));
    try {
        pizzaMaker = DAO.getInstance().loadPizzaMaker(id);
    } catch (Exception e) {
    }
    String name = "";
    String surname = "";
    String patronymic = "";
    double hourlyPay = 0;
    if (pizzaMaker != null) {
        if (pizzaMaker.getName() != null) {
            name = pizzaMaker.getName();
        }
        if (pizzaMaker.getSurname() != null) {
            surname = pizzaMaker.getSurname();
        }
        if (pizzaMaker.getPatronymic() != null) {
            patronymic = pizzaMaker.getSurname();
        }
        if (pizzaMaker.getHourlyPay() != 0) {
            hourlyPay = pizzaMaker.getHourlyPay();
        }
%>

<html>
<head>
    <title>Редактирование информации о пиццамэйкере</title>
    <link href="editStyle.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}icon.ico" type="image/x-icon">
</head>
<body>
<fieldset>
    <legend>Редактирование информации о пиццамэйкере:</legend>
    <form action="edit" method="post">
        <% if (error != null) { %>
        <div class="error"><%=error%></div>
        <% } %>
        <input type="hidden" name="id" value="<%=id%>"/>
        <label for="nameID">Имя:</label>
        <br>
        <input id="nameID" type="text" name="name" maxlength="30" value="<%=name%>" autofocus/>
        <br>
        <label for="surnameID">Фамилия:</label>
        <br>
        <input id="surnameID" type="text" name="surname" maxlength="30" value="<%=surname%>"/>
        <br>
        <label for="patronymicID">Отчество:</label>
        <br>
        <textarea id="patronymicID" type="text" name="patronymic" rows="5" cols="32"
                  maxlength="500"><%=patronymic%></textarea>
        <br>
        <label for="telephoneNumberID">Почасовая оплата:</label>
        <br>
        <textarea id="telephoneNumberID" type="text" name="telephoneNumber" rows="5" cols="32"
                  maxlength="500"><%=hourlyPay%></textarea>
        <br>
        <input class="button" type="submit" name="ok" value="       ОК      "/>
    </form>
</fieldset>
<%}%>
</body>
</html>