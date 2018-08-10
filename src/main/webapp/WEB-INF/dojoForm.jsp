<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>New Dojo</title>
  	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>
	<h1>New Dojo</h1>
	<div class="navbar">
		<a href="/">Home</a>
		<span>___</span>
		<a href="/ninjas/new">Add Ninja</a>
	</div>
	
	<form:form method="POST" action="/processNewDojo" modelAttribute="dojo">
		<form:label path="name">Name
		<form:errors path="name"/>
		<span>_____</span>
		<form:input path="name"/></form:label>
		
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>