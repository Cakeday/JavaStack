<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style><%@include file="WEB-INF/css/styles.css"%></style>
</head>
<body>


	<%
		int someNumber = (int) request.getParameter(height);
		int anotherNumber = (int) request.getParameter(width);
	%>
	<div class="wrapper">

            <hr>
            <h1>The second board</h1>
            <hr>

            <div class="checkerboard">
                <% for (int i = 0; i<someNumber; i++){ %>
                    <div class="row">
                        <% for (int j = 0; j<anotherNumber; j++) y in range (4) %>
                            <div class="column{{(x+y)%2+1}}"></div>
                        <% endfor %>
                    </div>
                <% } %>
            </div>
            
    </div>
	
</body>
</html>