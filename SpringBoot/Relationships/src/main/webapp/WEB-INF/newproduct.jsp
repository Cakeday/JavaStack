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

    <h1>New Product</h1>

    <form:form action="/createproduct" method="post" modelAttribute="product">
        <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="description">Description:</form:label>
            <form:errors path="description"/>
            <form:input path="description"/>
        </p>
        <p>
            <form:label path="price">Price:</form:label>
            <form:errors path="price"/>
            <form:input path="price"/>
        </p>
        <input type="submit" value="Create">
    </form:form>
    
</body>
</html>