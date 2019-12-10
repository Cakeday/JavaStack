<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <h1>Hello World</h1>
    <!-- <c:out value="${2+2}"/> -->

    <h1>All Languages</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${languages}" var="language">
            <tr>
                <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.currentVersion}"/></td>
                <td><a href="/languages/${language.id}/edit">Edit</a>|<a href="/languages/${language.id}/delete">Delete</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>


    
    <h1>New</h1>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <form:form action="/languages" method="post" modelAttribute="language">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:textarea path="creator"/>
        </p>
        <p>
            <form:label path="currentVersion">Current Version</form:label>
            <form:errors path="currentVersion"/>
            <form:input path="currentVersion"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>    
    
    









</body>
</html>