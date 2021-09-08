<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">BetaExpress</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <c:if test="${not empty user}">
                <li><a href="/user/list">Users</a></li>
                <li><a href="/product/clothing/list">Clothing</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty user}">
                <li><a href="/user"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
            </c:if>
            <c:if test="${not empty user}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout, ${user.firstName}</a></li>
            </c:if>
        </ul>
    </div>
</nav>
