<%@ page import="utils.DAO" %>
<%@ page import="models.Client" %>
<%@ page import="models.PizzaMaker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PizzaMaker pizzaMaker = null;
    try {

        int id = Integer.parseInt(request.getParameter("id"));
        pizzaMaker = DAO.getInstance().loadPizzaMaker(id);
    } catch (Exception e) {

    }%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Пиццамэйкеры</title>
    <link href="indexStyle.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}icon.ico" type="image/x-icon">
</head>
<body>
<h3 id="header">Пиццамэйкеры</h3>


<input class="button" type="button" name="Clients" value="Клиенты" onclick="redirect('clients.jsp')"/>
<input class="button" type="button" name="Orders" value="Заказы" onclick="redirect('index.jsp')"/>
<%
    String id = "";
    String name = "";
    String surname = "";
    String patronymic = "";
    String hourlyPay = "";

    if (pizzaMaker != null) {
        id = Double.toString(pizzaMaker.getID());
        if (pizzaMaker.getName() != null) {
            name = pizzaMaker.getName();
        }
        if (pizzaMaker.getSurname() != null) {
            surname = pizzaMaker.getSurname();
        }
        if (pizzaMaker.getPatronymic() != null) {
            patronymic = pizzaMaker.getPatronymic();
        }
        hourlyPay = Integer.toString(pizzaMaker.getHourlyPay());
    }
%>

<fieldset>
    <legend>Информация о пиццамэйкере:</legend>
    <p>
        <label>id:</label>
        <%=id%><br/>
        <label>Имя:</label>
        <%=name%><br/>
        <label>Фамилия:</label>
        <%=surname%><br/>
        <label>Отчество:</label>
        <%=patronymic%><br/>
        <label>Почасовая оплата:</label>
        <%=hourlyPay%><br/>
    </p>

    <input class="button" type="button" name="Add" value="Добавить" onclick="redirect('addPizzaMaker.jsp')"/>
    <input class="button" type="button" name="Edit" value="Редактировать" onclick="redirectWithSelectedID('editPizzaMaker.jsp')"/>
    <input class="button" type="button" name="Delete" value="Удалить" onclick="redirectWithSelectedID('deletePizzaMaker')"/>
</fieldset>
<fieldset>
    <legend>Все пиццамэйкеры:</legend>
    <p>
        <%

            for (PizzaMaker t : DAO.getInstance().LoadAllPizzaMakers()) {
                if (pizzaMaker != null && pizzaMaker.getID() == t.getID()) {
                    out.println("<tr><td><input type=\"radio\" name=\"t\"  value=\"" + t.getID() + "\" onclick=\"redirectWithID('pizzaMakers.jsp', " + t.getID() + ")\" checked=\"checked\"/>");
                } else {
                    out.println("<tr><td><input type=\"radio\" name=\"t\" value=\"" + t.getID() + "\" onclick=\"redirectWithID('pizzaMakers.jsp', " + t.getID() + ")\"/>");
                }
                out.println("<td><strong style=\"color:#A52A2A\";>" + t.getID() + "</strong></td>");
                out.println("<td>" + t.getName() + "</td></br>");
            }
        %>
    </p>
</fieldset>

<script>
    function redirect(page) {
        window.location = page;
    }

    function redirectWithID(page, id) {
        window.location = page + "?id=" + id;
    }

    function redirectWithSelectedID(page) {
        var id = document.querySelector("input[name='t']:checked").value;
        window.location = page + "?id=" + id;
    }
</script>
</body>
</html>