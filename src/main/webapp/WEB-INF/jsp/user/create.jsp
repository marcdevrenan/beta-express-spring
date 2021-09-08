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

<div class="container">
    <h2>User Form</h2>

    <form action="/user/create" method="post">
        <div class="form-group">
            <label>First Name:</label>
            <input type="text" class="form-control" name="firstName">
        </div>

        <div class="form-group">
            <label>Last Name:</label>
            <input type="text" class="form-control" name="lastName">
        </div>

        <div class="form-group">
            <label>Email:</label>
            <input type="email" class="form-control" placeholder="example@test.com" name="email">
        </div>

        <div class="form-group">
            <label>Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" name="password">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
