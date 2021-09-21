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

    <div class="page-header text-center">
        <h2>Users Summary</h2>
        <h4>Number of registered users: ${list.size()}</h4>
    </div>

    <div class="container">
        <c:if test="${not empty list}">
            <c:if test="${not empty message}">
                <div class="alert alert-danger">
                    ${message}
                </div>
            </c:if>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Products</th>

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
                        <td>${u.products.size()}</td>

                        <c:if test="${user.admin && user.id != u.id}">
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