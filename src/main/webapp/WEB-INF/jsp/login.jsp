<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <c:if test="${not empty message}">
        <div class="alert alert-info alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            ${message}
        </div>
    </c:if>
</div>

<div class="page-header text-center">
    <h2>BetaExpress Login</h2>
</div>

<div class="container text-center">

    <form action="/login" method="post">
        <div class="form-row">
            <div class="form-group col-md-5">
                <input type="email" class="form-control" placeholder="example@test.com" name="email">
            </div>
            <div class="form-group col-md-5">
                <input type="password" class="form-control" placeholder="password" name="password">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-2">
                <button type="submit" class="btn btn-info">Login</button>
            </div>
        </div>
    </form>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

</body>
</html>
