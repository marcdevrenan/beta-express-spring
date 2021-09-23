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
    <h2>Cart Summary</h2>
    <h4>Number of registered customers: ${cart.size()}</h4>
</div>

<div class="container">
    <form action="/cart" method="get">
        <button type="submit" class="btn btn-info">Add Cart</button>
    </form>

    <hr>

    <c:if test="${not empty cart}">
        <c:if test="${not empty message}">
            <div class="alert alert-info">
                    ${message}
            </div>
        </c:if>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Customer</th>
                <th>Products</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${cart}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.description}</td>
                    <td>${c.customer.firstName}</td>
                    <td>${c.products.size()}</td>
                    <td><a href="/cart/${c.id}/delete">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty cart}">
        <h3>No registered user...</h3>
    </c:if>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

</body>
</html>