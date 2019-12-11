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
    

    <h1>New</h1>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <form:form action="/songs" method="post" modelAttribute="song">
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>
        <p>
            <form:label path="artist">Artist</form:label>
            <form:errors path="artist"/>
            <form:textarea path="artist"/>
        </p>
        <p>
            <form:select path="rating">
                <option selected>Pick a number!</option>
                <c:forEach begin="1" end="10" varStatus="loop">
                    <form:option value="${loop.index}">${loop.index}</form:option> 
                </c:forEach>
            </form:select>
        </p>
        <input type="submit" value="Add Song"/>
    </form:form>    








</body>
</html>