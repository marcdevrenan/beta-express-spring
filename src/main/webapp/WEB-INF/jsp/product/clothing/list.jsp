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
        <form action="/product/clothing" method="get">
            <button type="submit" class="btn btn-info">Add</button>
        </form>
        <hr>

        <c:if test="${not empty clothing}">
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                        ${message}
                </div>
            </c:if>

            <h3>Number of registered products: ${clothing.size()}</h3>
            <hr>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Size</th>
                    <th>Color</th>
                    <th>Brand</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${clothing}">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>${c.price}</td>
                        <td>${c.qty}</td>
                        <td>${c.size}</td>
                        <td>${c.color}</td>
                        <td>${c.brand}</td>
                        <td><a href="/product/clothing/${c.id}/delete">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty clothing}">
            <h3>No product registered...</h3>
        </c:if>
    </div>

</body>
</html>