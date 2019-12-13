<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <h1>New Ninja</h1>

    <form:form action="/createninja" method="post" modelAttribute="ninja">
        <p>
            <form:select path="dojo">
                <option selected disabled>Pick a dojo!</option>
                <c:forEach items="${dojos}" var="dojo">
                    <form:option value="${dojo.id}">${dojo.name}</form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="firstName">First Name</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="age">Age</form:label>
            <form:errors path="age"/>
            <form:input path="age"/>
        </p>
        <input type="submit" value="Create">
    </form:form>
    
</body>
</html>