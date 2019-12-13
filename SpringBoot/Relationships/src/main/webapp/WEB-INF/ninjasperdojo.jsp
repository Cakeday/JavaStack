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

    <h1>${dojo.name} Location Ninjas</h1>

    <table>
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </thead>
        <c:forEach items="${ninjas}" var="ninja">
            <tr>
                <td>${ninja.firstName}</td>
                <td>${ninja.lastName}</td>
                <td>${ninja.age}</td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>