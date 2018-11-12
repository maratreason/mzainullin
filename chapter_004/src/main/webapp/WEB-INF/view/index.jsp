<%@ page import="ru.mzainullin.servlet.model.User" %>
<%@ page import="ru.mzainullin.servlet.logic.ValidateService" %><%--
  Created by IntelliJ IDEA.
  User: Марат
  Date: 09.09.2018
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Index</title>
    <style>
        h3, h4 {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">

    <h3>Добавить нового пользователя</h3>
    <hr>

    <form action="<%=request.getContextPath()%>/create" method="post">
        <div class="row">
        <div class="form-group col-6 col-md-4">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group col-6 col-md-4">
            <label for="login">Login</label>
            <input type="text" class="form-control" id="login" name="login">
        </div>
        <div class="form-group col-6 col-md-4">
            <label for="email">E-mail</label>
            <input type="text" class="form-control" id="email" name="email">
        </div>
        <button type="submit" class="btn btn-primary mx-auto">Добавить</button>
        </div>
    </form>
    <br>

    <h4>Таблица всех пользователей</h4>

    <hr>
    <br>

    <table class="table">
        <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                <th scope="col">LOGIN</th>
                <th scope="col">EMAIL</th>
                <th scope="col">CREATE_DATE</th>
                <th></th>
                <th></th>
            </tr>
        </thead>

        <tbody>

        <% for (User user : ValidateService.getInstance().getUsers()) {
            String actionEditPath = request.getContextPath() + "/edit?id=" + user.getId();
        %>

            <tr>
                <td scope="row"><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getCreateDate()%></td>

                <td>
                    <form action="<%=actionEditPath%>" method="post">
                        <input type='number' hidden name='id'>
                        <button type="submit" class="btn btn-warning">Редактировать</button>
                    </form>
                </td>

                <td>
                    <form action='/delete' method='post'>
                        <input type='number' hidden name='id' value="<%=user.getId()%>">
                        <button type="submit" class="btn btn-danger">Удалить</button>
                    </form>
                </td>
            </tr>

        <%}%>

        </tbody>
    </table>


</div>



</body>
</html>
