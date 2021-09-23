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

<c:set var="button" value=""/>

<div class="page-header text-center">
    <h2>Cart Summary</h2>
</div>

<div class="container">
    <form action="/cart/create" method="post">
        <div class="form-group">
            <c:if test="${not empty customers}">
                <label>Customer:</label>
                <select class="form-control" name="customer.id">
                    <c:forEach var="customer" items="${customers}">
                        <option value="${customer.id}">${customer.firstName}</option>
                    </c:forEach>
                </select>
            </c:if>

            <c:if test="${empty customers}">
                <c:set var="button" value="disabled"/>
                <label>Customer: There are no registered customers!</label>
            </c:if>
        </div>

        <div class="form-group">
            <label>Description:</label>
            <input type="text" class="form-control" placeholder="Enter the description" name="description">
        </div>

        <div class="form-group">
            <c:if test="${not empty products}">
                <label>Products:</label>
                <c:forEach var="product" items="${products}">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input name="productsId" type="checkbox" value="${product.id}">${product.name}
                        </label>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${empty products}">
                <c:set var="button" value="disabled"/>
                <label>Products: There are no registered products!</label>
            </c:if>
        </div>
        <button type="submit" ${button} class="btn btn-success">Generate Cart Order</button>
    </form>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

</body>
</html>
