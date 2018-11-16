<%@ page import="ru.mzainullin.DBStore.model.User" %>
<%@ page import="ru.mzainullin.DBStore.service.DBStore" %><%--
  Created by IntelliJ IDEA.
  User: Марат
  Date: 13.11.2018
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>DBStore Program</title>
</head>
<body>

<div class="container">

    <br>
    <form action="<%=request.getContextPath()%>/add" method="post">
        <div class="row">
            <button type="submit" class="btn btn-primary mx-auto">Добавить нового пользователя</button>
        </div>
    </form>

    <h4>Таблица всех пользователей</h4>

    <hr>
    <br>

    <h5>Поиск пользователя по его id</h5>

    <form action="<%=request.getContextPath() + "/searchId" %>" method="post">
        <input type="text" class="form-control" id="id" name="id"><br>
        <button type="submit" class="btn btn-warning">Найти</button>
    </form><hr>

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>

        <%
            for (User user : DBStore.getInstance().findAll()) {
            String actionEditPath = request.getContextPath() + "/update?id=" + user.getId();
        %>

        <tr>
            <td scope="row"><%=user.getId()%></td>
            <td scope="row"><%=user.getName()%></td>
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
