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
    <title>Добавление клиента</title>
    <link href="editStyle.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}icon.ico" type="image/x-icon">
</head>
<body>


<fieldset>
    <legend>Добавление клиента</legend>
    <form action="addClient" method="post">
        <% if (error != null) { %>
        <div class="error"><%=error%></div>
        <% } %>
        <label for="nameID">Имя:</label>
        <br>
        <input id="nameID" type="text" name="name" maxlength="30"  autofocus/>
        <br>
        <label for="surnameID">Фамилия:</label>
        <br>
        <input id="surnameID" type="text" name="surname" maxlength="30"/>
        <br>
        <label for="patronymicID">Отчество:</label>
        <br>
        <input id="patronymicID" type="text" name="patronymic" rows="5" cols="32"
               maxlength="500"/>
        <br>
        <label for="telephoneNumberID">Номер телефона:</label>
        <br>
        <input id="telephoneNumberID" type="text" name="telephoneNumber" rows="5" cols="32"
               maxlength="500"/>
        <br>
        <input class="button" type="submit" name="ok" id="ok" value="ОК" onclick=""/>
        <input class="button" type="button" name="cancel" id="cancel" value="Отменить" onclick="redirect('clients.jsp')"/>
    </form>
</fieldset>

<script>
    function redirect(page) {
        window.location = page;
    }
</script>
</body>
</html>