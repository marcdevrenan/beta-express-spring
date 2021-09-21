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
        <h2>Electronic Summary</h2>
        <h4>Number of registered products: ${electronic.size()}</h4>
    </div>

    <div class="container">
        <form action="/product/electronic" method="get">
            <button type="submit" class="btn btn-info">Add Product</button>
        </form>

        <c:if test="${not empty electronic}">
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                        ${message}
                </div>
            </c:if>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Manufacturer</th>
                    <th>Voltage</th>
                    <th>National</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="e" items="${electronic}">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td>${e.price}</td>
                        <td>${e.qty}</td>
                        <td>${e.manufacturer}</td>
                        <td>${e.voltage}</td>
                        <td>${e.national}</td>
                        <td><a href="/product/electronic/${e.id}/delete">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty electronic}">
            <h3>No product registered...</h3>
        </c:if>
    </div>

</body>
</html>