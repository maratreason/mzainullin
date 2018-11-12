<%@ page import="ru.mzainullin.servlet.model.User" %>
<%@ page import="ru.mzainullin.servlet.logic.ValidateService" %>
<%--
  Created by IntelliJ IDEA.
  User: Марат
  Date: 11.11.2018
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Редактирование страницы</title>
    <style>
        h3, h4 {
            text-align: center;
        }
    </style>
</head>
<body>

<h3>Изменение текущего пользователя</h3>
<hr>

<%
    String actionPath = request.getContextPath() + "/edit";
%>

<div class="container">
    <%
        for (User user : ValidateService.getInstance().getUsers()) {
    %>
    <form action="<%=actionPath%>" method="post">
        <div class="row">
            <div class="form-group col-6 col-md-3">
                <label for="id">Id</label>
                <input type="text" class="form-control" id="id" name="id" value="<%=user.getId()%>">
            </div>
            <div class="form-group col-6 col-md-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="<%=user.getName()%>">
            </div>
            <div class="form-group col-6 col-md-3">
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" name="login" value="<%=user.getLogin()%>">
            </div>
            <div class="form-group col-6 col-md-3">
                <label for="email">E-mail</label>
                <input type="text" class="form-control" id="email" name="email" value="<%=user.getEmail()%>">
            </div>
        </div>
        <center>
        <button type="submit" class="btn btn-primary mx-auto center">Обновить данные</button>
        </center>
        <hr>
    </form>
    <% }%>
</div>


</body>
</html>
