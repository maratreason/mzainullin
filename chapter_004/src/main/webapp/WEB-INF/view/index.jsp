<%--
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
    <title>My first JSP</title>
</head>
<body>

<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Login</th>
            <th scope="col">Email</th>
            <th scope="col">Date</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="user" items="${requestScope.users}">

        <tr>
            <th scope="row"></th>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.createDate}"/></td>
        </tr>

            </c:forEach>

        </tbody>
    </table>

    <hr>

    <h1>Create new user</h1>

    <form method="post" class="mt-3">
        <div class="form-group">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" placeholder="Name" name="name">
        </div>
        <div class="form-group">
            <label>Login</label>
            <input type="text" class="form-control" placeholder="Login" name="login">
        </div>
        <div class="form-group">
            <label>Email address</label>
            <input type="text" class="form-control" id="" placeholder="Email" name="email">
        </div>
        <button type="submit" class="btn btn-success" name="submit">Submit</button>
    </form>


    <%--<form action="" method="post">--%>
        <%--<input type="text" name="name" value="name"><br>--%>
        <%--<input type="text" name="login" value="login"><br>--%>
        <%--<input type="text" name="email" value="email"><br>--%>
        <%--<input type="submit" value="Submit" name="submit">--%>
    <%--</form>--%>
</div>



</body>
</html>
