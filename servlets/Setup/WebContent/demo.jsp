<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Date"%>
<!DOCTYPE html5>
<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
</head>
<body>
	<%!
	public int add(int a, int b){
		return a+b;
	}
	%>
	
	<% int i = 2; int j = 4; %>
	
	<h3>Something here <%= add(i, j) %></h3>
	
	<% for(int index = 0; index<5; index++){ %>
	<h1><%= index %></h1>
	<%  }  %>
	
	<p>The time is <%= new Date() %></p>
	
</body>
</html>