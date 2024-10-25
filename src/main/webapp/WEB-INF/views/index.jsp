<%@ page import="java.util.List" %>
<%@ page import="org.example.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 25/10/2024
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of Users</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Retrieve the users list from the request
        List<User> users = (List<User>) request.getAttribute("users");
        if (users != null && !users.isEmpty()) {
            // Iterate over the users and display their details
            for (User user : users) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getFirstName() %></td>
        <td><%= user.getEmail() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">No users found.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
