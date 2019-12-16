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
<style>
	body{
		display:flex;
		justify-content:space-around;
	}
	.container {
		display:inline-block;
		vertical-align:top;
		border:1px solid black;
		width:400px;
		padding:20px;
	}
	button{
		background-color: green;
		border-radius:5px;
		padding: 10px 15px;
		border-color:green;
		color:white;
	}
</style>
</head>
<body>
	<div class="container">
	 	<h1>Edit a advertisement!</h1>
	    
	    <p><form:errors path="advertisement.*"/></p>
	    
	    <form:form method="POST" action="/edit/advertisement/${advertisement.id}" modelAttribute="advertisement">
	     <p>
	            <form:label path="name">Name:</form:label>
	            <form:input type="text" path="name"/>
	        </p>
	        <p>
	            <form:label path="content">Content:</form:label>
	            <form:input type="text" path="content"/>
	        </p>
	       
	        <button type="submit">Submit</button>
	    </form:form>
    </div>
    
</body>
</html>