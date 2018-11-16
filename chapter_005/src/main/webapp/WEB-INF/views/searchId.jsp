<%@ page import="ru.mzainullin.DBStore.service.DBStore" %>
<%@ page import="ru.mzainullin.DBStore.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Марат
  Date: 16.11.2018
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Search By Id</title>
</head>
<body>

<div class="container">
    <table class="table">

            <thead class="thead-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                </tr>
            </thead>

            <tbody>

            <%
                for (User user : DBStore.getInstance().findAll()) {
                    String actionEditPath = request.getContextPath() + "/searchId?id=" + user.getId();
                    String id = request.getParameter("id");
                    if (user.getId().equals(id) && user.getId() != null) {
            %>

                <tr>
                    <td scope="row"><%=user.getId()%></td>
                    <td scope="row"><%=user.getName()%></td>
                </tr>

            <%}}%>

        </tbody>
    </table>
</div>

</body>
</html>
