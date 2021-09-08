<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>BetaExpress</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

    <c:import url="/WEB-INF/jsp/navbar.jsp"/>

    <div class="container">
        <c:if test="${not empty list}">
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if>

            <h3>Number of registered users: ${list.size()}</h3>
            <hr>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>

                    <c:if test="${user.admin}">
                        <th></th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="u" items="${list}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.firstName}</td>
                        <td>${u.lastName}</td>
                        <td>${u.email}</td>

                        <c:if test="${user.admin}">
                            <td><a href="/user/${u.id}/delete">Delete</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty list}">
            <h3>No registered user...</h3>
        </c:if>
    </div>

</body>
</html>