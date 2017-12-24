<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Registration</title>
<style type="text/css">
		.backimg{
			background-image: url("http://www.nicekicks.com/files/2017/02/Nike-Air-Huarache-Run-Matte-Silver.jpg");
			height: 620px;
		}
		.text{
			color: white;
		}
	</style>
</head>
<body>
<div class="backimg">
<nav class="navbar-inverse navbar-static-top topheader">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">SPORT</a>
    </div>
  </div>
</nav>
<form:form class="form-horizontal" modelAttribute="user" action="/registration" type="POST" >
<div>
	<h1 class="text text-center">Registration</h1>
</div>
  	<div class="form-group">
  			  <form:errors path="email" element="div">
  			  </form:errors>
   			  <label class="col-sm-3 control-label text">Email</label>
  	 	 <div class="col-sm-6">
   	 		  <form:input path="email" type="email" class="form-control" placeholder="Email"/>
   		</div>
  	</div>
  	<div class="form-group">
   			  <label class="col-sm-3 control-label text">Password</label>
   		 <div class="col-sm-6">
      	      <form:input path="password" type="password" class="form-control" placeholder="Password"/>
   		 </div>
  	</div>
  	<div class="form-group">
   			  <label class="col-sm-3 control-label text">Password repeat</label>
   		 <div class="col-sm-6">
      	      <form:input path="passwordRepeat" type="password" class="form-control" placeholder="Password repeat"/>
   		 </div>
  	</div>
  	<div class="form-group">
   			  <label class="col-sm-3 control-label text">Sure name</label>
  	 	 <div class="col-sm-6">
   	 		  <form:input path="surname" class="form-control" placeholder="Surname"/>
   		</div>
  	</div>
  	<div class="form-group">
   			  <label class="col-sm-3 control-label text">Name</label>
  	 	 <div class="col-sm-6">
   	 		  <form:input path="name" class="form-control" placeholder="Name"/>
   		</div>
  	</div>
  	<div class="form-group">
   			  <label class="col-sm-3 control-label text">Last name</label>
  	 	 <div class="col-sm-6">
   	 		  <form:input path="lastname" class="form-control" placeholder="Lastname"/>
   		</div>
  	</div>
  <div class="form-group">
    <div class="col-sm-offset-8 col-sm-2">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form:form>
</div>
</body>
</html>