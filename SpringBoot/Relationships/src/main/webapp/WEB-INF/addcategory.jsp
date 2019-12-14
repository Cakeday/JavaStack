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

    <h1>${product.name}</h1>

    <h3>Categories:</h3>
    <ul>
        <c:forEach items="${categories}" var="category">
            <c:if test="${product.categories.contains(category) == true}">
                <li>${category.name}</li>
            </c:if>
        </c:forEach>
    </ul>




    <form:form action="/addcategory/${product.id}" method="post" modelAttribute="product">
        <p>
            <form:select path="categories" multiple="false">
                <option selected disabled>Pick a category!</option>
                <c:forEach items="${categories}" var="category">
                    <c:if test="${product.categories.contains(category) == false}">
                        <form:option value="${category.id}">${category.name}</form:option>
                    </c:if>
                </c:forEach>
            </form:select>
        </p>
        <input type="submit" value="Add Category">
    </form:form>

</body>

</html>