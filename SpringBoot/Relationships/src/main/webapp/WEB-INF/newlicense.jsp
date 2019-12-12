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
    <h1>New License</h1>

    <form:form action="/createlicense" method="post" modelAttribute="license">
        <p>
            <form:select path="person">
                <option selected>Pick a number!</option>
                <c:forEach items="${allPeople}" var="person">
                    <form:option value="${person}">${person.firstName} ${person.lastName}</form:option> 
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input path="state"/>
        </p>
        <p>
            <form:label path="expirationDate">Expiration Date</form:label>
            <form:errors path="expirationDate"/>
            <fmt:formatDate pattern="dd/MM/yyyy" var="myDate" />
            <form:input type="date" path="expirationDate" value="${myDate}"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
    
</body>
</html>