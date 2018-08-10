<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
  	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>
	<h1>New Ninja</h1>
	<div class="navbar">
		<a href="/">Home</a>
		<span>___</span>
		<a href="/dojos/new">Add Dojo</a>
	</div>
	
	<form:form method="POST" action="/processNewNinja" modelAttribute="ninja">

	    <form:label path="dojo">Dojo
	    <span>_________</span>
	    <select name="dojo">
	 		<c:forEach var="dojo" items="${allDojos }">
	    		<option label="${dojo.name} " value="${dojo.id }"></option>
	    	</c:forEach>
	    </select></form:label>
	    <h1></h1>

        <form:label path="firstName">First Name
        <form:errors path="firstName"/>
        <span>___</span>
        <form:input path="firstName"/></form:label>
        <h1></h1>
		
        <form:label path="lastName">Last Name
        <form:errors path="lastName"/>
        <span>___</span>
        <form:input path="lastName"/></form:label>
        <h1></h1>

        <form:label path="age">Age
        <form:errors path="age"/>
        <span>________</span>
        <form:input path="age"/></form:label>
        <h1></h1>
		
		<input type="submit" value="Create" class="createButton"/>
		
	</form:form>
</body>
</html>