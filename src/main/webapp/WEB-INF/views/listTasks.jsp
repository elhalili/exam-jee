<%@ page import="java.util.List" %>
<%@ page import="ac.usmba.estf.gl.examjee.models.Task" %><%--
  Created by IntelliJ IDEA.
  User: amine-elhalili
  Date: 22/03/2023
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List tasks</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    <link rel="stylesheet" href="http://localhost:8080/exam/styles/main.css">
</head>
<body>
<%@include file="headerComponent.jsp" %>
<main class="flex-around">
    <h1>Tasks list</h1>
    <section id="listTasks">
        <table>
            <% List<Task> tasks = (List<Task>) request.getAttribute("tasks"); %>
            <caption>List of tasks</caption>
            <tbody id="listTask">
            <% for (Task task: tasks) {%>
                <tr>
                    <td><%= task.getContent() %></td>
                    <td>
                        <a class="delete" href="deleteTask?id=<%= task.getId() %>">
                            <i class="fa fa-close"></i>
                        </a>
                    </td>
                    <td>
                        <a class="top" href="orderTask?id=<%= task.getId() %>&order=up">
                            <i class="fa fa-arrow-up"></i>
                        </a>
                        <a class="bottom" href="orderTask?id=<%= task.getId() %>&order=down">
                            <i class="fa fa-arrow-down"></i>
                        </a>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
