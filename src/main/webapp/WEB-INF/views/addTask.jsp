<%--
  Created by IntelliJ IDEA.
  User: amine-elhalili
  Date: 22/03/2023
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://localhost:8080/exam/styles/main.css">
    <title>Add new task</title>
</head>
<body>
    <%@include file="headerComponent.jsp" %>
    <main class="flex-around">
        <h1>Add task</h1>
        <section id="addForm">
            <form method="post" action="addTask">
                <div>
                    <input type="text" name="content" placeholder="Task">
                </div>
                <div class="">
                    <button type="reset">reset</button>
                    <button type="submit">submit</button>
                </div>
            </form>
        </section>
    </main>
</body>
</html>
