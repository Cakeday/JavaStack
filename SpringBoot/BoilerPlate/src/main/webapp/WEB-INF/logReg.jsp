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
	 	<h1>Register!</h1>
	    
	    <p><form:errors path="user_r.*"/></p>
	    
	    <form:form method="POST" action="/registration" modelAttribute="user_r">
	     <p>
	            <form:label path="name">Name:</form:label>
	            <form:input type="text" path="name"/>
	        </p>
	        <p>
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email"/>
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label>
	            <form:password path="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation"/>
	        </p>
	        <button type="submit">Register</button>
	    </form:form>
    </div>
    <div class="container">
	 	<h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email_l"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password_l"/>
        </p>
       <button type="submit">Login</button>
    </form>    
    </div>
</body>
</html>