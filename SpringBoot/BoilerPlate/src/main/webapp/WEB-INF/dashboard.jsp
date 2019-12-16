<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
	 	  <table>
        <thead>
            <tr>
                <th>name</th>
                <th>field2</th>
                <th>action</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${as }" var="item">
        
            <tr>
                <td><a href="/show/advertisement/${item.id}">${item.name}</a></td>
                <td>${item.content}</td>
                <td>
                    <a href="/edit/advertisement/${item.id}">Edit</a> |
                    <a href="/delete/advertisement/${item.id}">Delete</a>
                </td>
            </tr>
                </c:forEach>
            
        </tbody>
    </table>
    <table>
        <thead>
            <tr>
                <th>name</th>
                <th>field2</th>
                <th>action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${ms}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.pages}</td>
                <td>
                <c:if test="${u.sponsor == null}">
                        <a href="/magazine/${item.id}/join">Join</a>
                    </c:if>
                    <c:if test="${item.coverModels.contains(u) == true && u.sponsor != null}">
                        <a href="/magazine/cancel">Cancel</a>
                    </c:if>
                    </td>
            </tr>
                </c:forEach>
            
        </tbody>
    </table>
    <a href="/create/magazine">Create a Magazine</a>
        <a href="/create/advertisement">Create a Advertisement</a>
    
    </div>
</body>
</html>