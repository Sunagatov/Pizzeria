<%@ page import="models.Client" %>
<%@ page import="utils.DAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отлично!</title>
</head>
<body>
<%
    out.println(DAO.getInstance().LoadAllClients());
    out.println(DAO.getInstance().LoadAllPizzaMakers());
%>
</body>
</html>
