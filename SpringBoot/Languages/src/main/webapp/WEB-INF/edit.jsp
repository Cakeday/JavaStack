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

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
        <h3>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </h3>
        <h3>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:textarea path="creator"/>
        </h3>
        <h3>
            <form:label path="currentVersion">Current Version</form:label>
            <form:errors path="currentVersion"/>
            <form:input path="currentVersion"/>
        </h3>
        <input type="submit" value="Submit"/>
    </form:form>    
    
</body>
</html>