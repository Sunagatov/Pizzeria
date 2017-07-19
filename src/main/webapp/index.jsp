<%@ page import="java.util.Collections" %>
<%@ page import="utils.DAO" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="models.Client" %>
<%@ page import="models.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Order order = null;
    try {

        int id = Integer.parseInt(request.getParameter("id"));
        order = DAO.getInstance().loadOrder(id);
    } catch (Exception e) {

    }%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Главная страница</title>
    <link href="IndexStyle.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}icon.ico" type="image/x-icon">
</head>
<body>
<h3 id="header">Главная страница</h3>


<input class="button" type="button" name="Clients" value="Клиенты" onclick="redirect('Clients.jsp')"/>
<input class="button" type="button" name="PizzaMakers" value="Пиццамейкеры" onclick="redirect('PizzaMakers.jsp')"/>
<%
    String idOrder = "";
    String pizzaName = "";
    String pizzaSize = "";
    String pizzaPrice = "";
    String clientName = "";
    String pizzaMakerName = "";
    String startDate = "";
    String endDate = "";
    String status = "";

    if (order != null) {
        idOrder = Integer.toString(order.getID());
        if (order.getPizza() != null) {
            pizzaName = order.getPizza().getName();
            pizzaSize = Double.toString(order.getPizza().getSize());
            pizzaPrice = Double.toString(order.getPizza().getPrice());
        }
        if (order.getClient() != null) {
            clientName = order.getClient().getName();
        }
        if (order.getPizzaMaker() != null) {
            pizzaMakerName = order.getPizzaMaker().getName();
        }
        if (order.getStartDate() != null) {
            startDate = order.getStartDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        }
        if (order.getEndDate() != null) {
            endDate = order.getEndDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        }
        if (order.getStatus() != null) {
            if (order.getStatus().ordinal() == 0) {
                status = "start";
            } else if (order.getStatus().ordinal() == 1) {
                status = "process";
            } else {
                status = "finish";
            }
        }
    }
%>
<fieldset>
    <legend>Информация о заказе:</legend>
    <p>
        <input type="hidden" name="id" value="<%=idOrder%>"/>
        <label>id:</label>
        <%=idOrder%><br/>
        <label>Название пиццы:</label>
        <%=pizzaName%><br/>
        <label>Размер пиццы:</label>
        <%=pizzaSize%><br/>
        <label>Цена пиццы:</label>
        <%=pizzaPrice%><br/>
        <label>Имя пиццемэйкера:</label>
        <%=pizzaMakerName%><br/>
        <label>Имя клиента:</label>
        <%=clientName%><br/>
        <label>Дата создания:</label>
        <%=startDate%><br/>
        <label>Дата окончания работ:</label>
        <%=endDate%><br/>
        <label>Статус:</label>
        <%=status%><br/>
    </p>
    <input class="button" type="button" name="Add" value="Добавить" onclick="redirect('AddOrder.jsp')"/>
    <input class="button" type="button" name="Edit" value="Редактировать"
           onclick="redirectWithSelectedID('EditOrder.jsp')"/>
    <input class="button" type="button" name="Delete" value="Удалить" onclick="redirectWithSelectedID('deleteOrder')"/>
</fieldset>


<fieldset>
    <legend>Все заказы:</legend>
    <p>
        <%
            for (Order t : DAO.getInstance().LoadAllOrders()) {
                if (order != null && order.getID() == t.getID()) {
                    out.println("<tr><td><input type=\"radio\" name=\"t\"  value=\"" + t.getID() + "\" onclick=\"redirectWithID('index.jsp', " + t.getID() + ")\" checked=\"checked\"/>");
                } else {
                    out.println("<tr><td><input type=\"radio\" name=\"t\" value=\"" + t.getID() + "\" onclick=\"redirectWithID('index.jsp', " + t.getID() + ")\"/>");
                }
                out.println("<td><strong style=\"color:#A52A2A\";>" + t.getID() + "</strong></td>");
                out.println("<td>" + "<strong style=\"color:#A52A2A\";>пицца - </strong></td>" +
                        t.getPizza().getName() + ", <strong style=\"color:#A52A2A\";>клиент - </strong>" +
                        t.getClient().getName() + ", <strong style=\"color:#A52A2A\";>пиццамэйкер - </strong>" +
                        t.getPizzaMaker().getName() + "</td></br>");

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