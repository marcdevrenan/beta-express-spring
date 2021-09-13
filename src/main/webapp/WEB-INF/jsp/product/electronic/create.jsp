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
        <h2>Electronic Form</h2>

        <form action="/product/electronic/create" method="post">
            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" name="name">
            </div>

            <div class="form-group">
                <label>Price:</label>
                <input type="number" min="1" step="any" class="form-control" name="price">
            </div>

            <div class="form-group">
                <label>Qty:</label>
                <input type="number" min="1" step="any" class="form-control" name="qty">
            </div>

            <div class="form-group">
                <label>Manufacturer:</label>
                <input type="text" class="form-control" name="manufacturer">
            </div>

            <div class="form-group">
                <label>Voltage:</label>
                <input type="text" class="form-control" name="voltage">
            </div>

            <div class="checkbox">
                <label><input type="checkbox" name="national">National</label>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

</body>
</html>