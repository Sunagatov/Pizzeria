<%@ page import="java.util.Collections" %>
<%@ page import="utils.DAO" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="models.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Client client = null;
    try {

        int id = Integer.parseInt(request.getParameter("id"));
        client = DAO.getInstance().loadClient(id);
    } catch (Exception e) {

    }%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Клиенты</title>
    <link href="indexStyle.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}icon.ico" type="image/x-icon">
</head>
<body>
<h3 id="header">Клиенты</h3>


<input class="button" type="button" name="Orders" value="Заказы" onclick="redirect('index.jsp')"/>
<input class="button" type="button" name="PizzaMakers" value="Пиццамейкеры" onclick="redirect('pizzaMakers.jsp')"/>
<%
    String id = "";
    String name = "";
    String surname = "";
    String patronymic = "";
    String telephoneNumber = "";

    if (client != null) {
        id = Integer.toString(client.getID());
        if (client.getName() != null) {
            name = client.getName();
        }
        if (client.getSurname() != null) {
            surname = client.getSurname();
        }
        if (client.getPatronymic() != null) {
            patronymic = client.getPatronymic();
        }

            telephoneNumber = Integer.toString(client.getTelephoneNumber());

    }
%>
<fieldset>
    <legend>Информация о клиенте:</legend>
    <p>
        <label>id:</label>
        <%=id%><br/>
        <label>Имя:</label>
        <%=name%><br/>
        <label>Фамилия:</label>
        <%=surname%><br/>
        <label>Отчество:</label>
        <%=patronymic%><br/>
        <label>Номер телефона:</label>
        <%=telephoneNumber%><br/>
    </p>

    <input class="button" type="button" name="Add" value="Добавить" onclick="redirect('addClient.jsp')"/>
    <input class="button" type="button" name="Edit" value="Редактировать" onclick="redirectWithSelectedID('editClient.jsp')"/>
    <input class="button" type="button" name="Delete" value="Удалить" onclick="redirectWithSelectedID('deleteClient')"/>
</fieldset>

<fieldset>
    <legend>Все клиенты:</legend>
    <p>
        <%
            for (Client t : DAO.getInstance().LoadAllClients()) {
                if (client != null && client.getID() == t.getID()) {
                    out.println("<tr><td><input type=\"radio\" name=\"t\"  value=\"" + t.getID() + "\" onclick=\"redirectWithID('clients.jsp', " + t.getID() + ")\" checked=\"checked\"/>");
                } else {
                    out.println("<tr><td><input type=\"radio\" name=\"t\" value=\"" + t.getID() + "\" onclick=\"redirectWithID('clients.jsp', " + t.getID() + ")\"/>");
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