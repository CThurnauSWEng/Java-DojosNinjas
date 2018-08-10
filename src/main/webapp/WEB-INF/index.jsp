<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Dojos Ninjas</title>
  	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<h1>Dojos</h1>
	<div class="navbar">
		<a href="/dojos/new">Add Dojo</a>
		<span>___</span>
		<a href="/ninjas/new">Add Ninja</a>
	</div>
	<p></p>

	<div class="navbar">
		<c:forEach items="${allDojos }" var = "dojo"> 	
			<h1><a href="/dojo/${dojo.id}">${dojo.name}</a></h1>
			<p></p>
		<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${dojo.ninjas }" var = "ninja">
				<tr>
					<td>${ninja.firstName }</td>
					<td>${ninja.lastName }</td>
					<td>${ninja.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
			
		</c:forEach>		
	</div>
</body>
</html>