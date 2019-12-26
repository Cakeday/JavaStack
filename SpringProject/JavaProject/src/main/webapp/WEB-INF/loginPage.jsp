<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://unpkg.com/turretcss/dist/turretcss.min.css" crossorigin="anonymous">

</head>
<body>

    <c:if test="${logoutMessage != null}">
        <p><c:out value="${logoutMessage}"></c:out></p>
    </c:if>

    <h1 class="padding-xxl">Login</h1>
    
    <c:if test="${errorMessage != null}">
        <p><c:out value="${errorMessage}"></c:out></p>
    </c:if>

    <form class="padding-horizontal-xxl padding-top-l" method="POST" action="/login">
        <p class="field padding-horizontal-xxl">
            <label for="form-simple-email">Username</label>
            <input type="email" id="form-simple-email" name="username" placeholder="Enter Email"/>
        </p>
        <p class="field padding-horizontal-xxl">
            <label for="form-simple-password">Password</label>
            <input type="password" id="form-simple-password" name="password" placeholder="Enter Password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p class="field padding-horizontal-xxl">
            <input type="submit" value="Login!"/>
        </p>
    </form>

</body>
</html>