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

<input class = "button" type="button" name="Schedule" value="Добавить" onclick="redirect('schedule.jsp')"/>
<input class = "button" type="button" name="Edit" value="Редактировать" onclick="redirectWithSelectedID('edit.jsp')"/>
<input class = "button" type="button" name="Delete" value="Удалить" onclick="redirectWithSelectedID('delete')"/>


<%
    String id = "";
    String name = "";
    String surname = "";
    String patronymic = "";
    String hourlypay =  "";

    if (pizzaMaker != null) {
        id = Double.toString(pizzaMaker.getID());
        if (pizzaMaker.getName() != null) {
            name = pizzaMaker.getName();
        }
        if (pizzaMaker.getSurname() != null) {
            surname = pizzaMaker.getSurname();
        }
        if (pizzaMaker.getPatronymic()!= null) {
            patronymic = pizzaMaker.getPatronymic();
        }
        if (pizzaMaker.getHourlyPay() != 0) {
            hourlypay = Double.toString(pizzaMaker.getHourlyPay());
        }
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
        <%=hourlypay%><br/>
    </p>
</fieldset>

<fieldset>
    <legend>Все пиццамэйкеры:</legend>
    <p>
        <%

            for (PizzaMaker t : DAO.getInstance().LoadAllPizzaMakers()) {
                if (pizzaMaker != null && pizzaMaker.getID() == t.getID()) {
                    out.println("<tr><td><input type=\"radio\" name=\"t\"  value=\"" + t.getID() + "\" onclick=\"redirectWithID('index.jsp', " + t.getID() + ")\" checked=\"checked\"/>");
                } else {
                    out.println("<tr><td><input type=\"radio\" name=\"t\" value=\"" + t.getID() + "\" onclick=\"redirectWithID('index.jsp', " + t.getID() + ")\"/>");
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