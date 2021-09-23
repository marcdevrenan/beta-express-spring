<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/navbar.jsp"/>

<div class="container-fluid">
    <div class="jumbotron text-center">
        <h1>BetaExpress</h1>
        <p>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>
    </div>
</div>

<div class="container-fluid bg-3 text-center">
    <h2>Products</h2>

    <hr>

    <div class="row">
        <div class="col-sm-4">
            <h4><b>Clothing</b></h4>
            <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ultricies sagittis
                nulla at ultricies. Donec consectetur bibendum massa vel efficitur. Integer posuere lorem eu dapibus
                viverra. Sed pulvinar nec enim et dictum. Aliquam venenatis ut nisi quis dictum. Nulla eget vehicula
                lacus. Duis in posuere diam. Nulla ut elit lorem. Nulla rutrum rutrum nisl sed suscipit.</p>
        </div>
        <div class="col-sm-4">
            <h4><b>Electronic</b></h4>
            <p class="text-justify">Nulla at aliquam purus. Fusce tempus nunc ex, sed consequat mauris faucibus a. Donec
                venenatis risus nec sem eleifend posuere. Interdum et malesuada fames ac ante ipsum primis in faucibus.
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque consectetur vitae nisi ut vestibulum.
                Cras et mi id turpis laoreet maximus id at velit. Nunc cursus sed mauris a elementum. Curabitur vel odio
                tellus. Integer sit amet porttitor ligula, tincidunt vehicula velit. Praesent luctus iaculis pharetra.
                Vestibulum sit amet mauris suscipit neque facilisis faucibus. Nunc lacinia et leo non sodales.</p>
        </div>
        <div class="col-sm-4">
            <h4><b>Grocery</b></h4>
            <p class="text-justify">Sed at magna eu tortor dictum condimentum sed ut mi. Fusce eget dolor sed diam
                semper bibendum. Quisque porta enim vel diam dapibus, vulputate dictum diam pretium. Nam urna felis,
                molestie sed libero quis, facilisis iaculis lectus. Nullam quis nulla in nisi euismod tincidunt. Fusce
                id imperdiet tellus, non vulputate metus. Fusce eu aliquam velit, in laoreet diam. In in nisl eget
                tortor viverra mollis at eget risus. Sed vulputate urna vitae augue maximus ornare.</p>
        </div>
    </div>

    <div class="container">
        <h2>System Inventory</h2>
        <ul class="list-group">
            <c:forEach var="map" items="${inventory}">
                <li class="list-group-item">${map.key}<span class="badge">${map.value}</span></li>
            </c:forEach>
        </ul>
    </div>
</div>

<footer class="container-fluid text-center">
    <div class="jumbotron navbar-inverse">
        <h5>Project Architect:<b>Elberth Moraes</b></h5>
        <h5>Project Developed By:<a target="_blank" href="https://github.com/marcdevrenan">github.com/marcdevrenan</a>
        </h5>
    </div>
</footer>

</body>
</html>
