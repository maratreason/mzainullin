<%--
  Created by IntelliJ IDEA.
  User: Марат
  Date: 14.11.2018
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>add</title>
</head>
<body>

<h3>Добавить нового пользователя</h3>
<hr>

<div class="container">
    <form action="<%=request.getContextPath()%>/add" method="post">
        <div class="row">
            <div class="form-group col-6 col-md-6">
                <label for="name">Id</label>
                <input type="text" class="form-control" id="id" name="id">
            </div>
            <div class="form-group col-6 col-md-6">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <button type="submit" class="btn btn-primary mx-auto">Добавить</button>
        </div>
    </form>
</div>

</body>
</html>
