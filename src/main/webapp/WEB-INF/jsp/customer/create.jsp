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
    <h2>Customer Form</h2>
</div>

    <form action="/customer/create" method="post">
        <div class="form-row">
            <div class="form-group col-md-3">
                <input type="text" class="form-control" placeholder="first name" name="firstName">
            </div>

            <div class="form-group col-md-3">
                <input type="text" class="form-control" placeholder="last name" name="lastName">
            </div>

            <div class="form-group col-md-3">
                <input type="email" class="form-control" placeholder="example@test.com" name="email">
            </div>

            <div class="form-group col-md-3">
                <input type="text" class="form-control" placeholder="(XX) XXXXX-XXXX" name="contact">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>
        </div>
    </form>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

</body>
</html>
