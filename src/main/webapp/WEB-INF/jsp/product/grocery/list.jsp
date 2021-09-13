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
        <form action="/product/grocery" method="get">
            <button type="submit" class="btn btn-info">Add Product</button>
        </form>
        <hr>

        <c:if test="${not empty grocery}">
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                        ${message}
                </div>
            </c:if>

            <h3>Number of registered products: ${grocery.size()}</h3>
            <hr>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Distributor</th>
                    <th>Weight</th>
                    <th>Validity</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="g" items="${grocery}">
                    <tr>
                        <td>${g.id}</td>
                        <td>${g.name}</td>
                        <td>${g.price}</td>
                        <td>${g.qty}</td>
                        <td>${g.distributor}</td>
                        <td>${g.weight}</td>
                        <td>${g.validity}</td>
                        <td><a href="/product/grocery/${g.id}/delete">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty grocery}">
            <h3>No product registered...</h3>
        </c:if>
    </div>

</body>
</html>