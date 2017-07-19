<%@ page import="models.Client" %>
<%@ page import="utils.DAO" %>
<%@ page import="models.PizzaMaker" %>
<%@ page import="models.Pizza" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = null;
    try {
        error = (String) request.getSession().getAttribute("error");
        if(error!=null) {
            request.getSession().removeAttribute("error");
        }
    } catch (Exception e) {

    }
%>
<html>
<head>
    <title>Добавление заказа</title>
    <link href="EditStyle.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}icon.ico" type="image/x-icon">
</head>
<body>


<fieldset>
    <legend>Добавление заказа</legend>
    <form action="addOrder" method="post">
        <% if (error != null) { %>
        <div class="error"><%=error%></div>
        <% } %>
        <label>Клиенты:</label>
        <br>
        <select name="clientID">
            <%
                for(Client t: DAO.getInstance().LoadAllClients()) {
                    out.println("<option value=\"" +t.getID()+"\">"+t.getName()+"</option>");
                }
            %>
        </select>
        <br>
        <label>Пиццамэйкеры:</label>
        <br>
        <select name="pizzaMakerID">
            <%
                for(PizzaMaker t: DAO.getInstance().LoadAllPizzaMakers()) {
                    out.println("<option value=\"" +t.getID()+"\">"+t.getName()+"</option>");
                }
            %>
        </select>
        <br>
        <label>Пиццы:</label>
        <br>
        <select name="pizzaID">
            <%
                for(Pizza t: DAO.getInstance().loadAllPizzas()) {
                    out.println("<option value=\"" +t.getID()+"\">"+t.getName()+"</option>");
                }
            %>
        </select>
        <br>
        <label for="startDateID">Дата создания:</label>
        <br>
        <input id="startDateID" type="text" name="startDate" rows="5" cols="32" maxlength="500" value = "<%=LocalDateTime.now().plusMinutes(2).format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))%>" />
        <br>
        <label for="endDateID">Дата окончания работ:</label>
        <br>
        <input id="endDateID" type="text" name="endDate" rows="5" cols="32" maxlength="500" value = "<%=LocalDateTime.now().plusMinutes(500).format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))%>"/>
        <br>
        <input class="button" type="submit" name="ok" id="ok" value="       ОК      " onclick=""/>
        <input class="button" type="button" name="cancel" id="ok" value="Отменить" onclick="redirect('index.jsp')"/>
    </form>
</fieldset>
<script>
    function redirect(page) {
        window.location = page;
    }
</script>
</body>
</html>