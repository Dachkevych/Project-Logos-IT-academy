<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Admin</title>
	<style type="text/css">
		body{
			background-color: 	#EBEBEB;
		}
	</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
      <a class="navbar-brand" href="/">Sport</a>
      <ul class="nav navbar-nav text-center">
        <li><a href="/admin/brand">Brand</a></li>
        <li><a href="/admin/category">Category</a></li>
        <li><a href="/admin/color">Color</a></li>
        <li><a href="/admin/gender">Gender</a></li>
        <li><a href="/admin/material">Material</a></li>
        <li><a href="/admin/season">Season</a></li>
        <li><a href="/admin/commodity">Commodity</a></li>
      </ul>
      <sec:authorize access="isAuthenticated()">
		<form:form action="/logout">
				<button type="submit" class="navbar-brand navbar-right btn btn-link">Logout</button>
		</form:form>
	</sec:authorize>
    </div>
</nav>
</body>
</html> 