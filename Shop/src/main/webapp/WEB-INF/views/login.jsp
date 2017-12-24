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
<title>Login</title>
<style type="text/css">
		.backimg{
			background-image: url("http://i.ebayimg.com/images/g/WoYAAOSw-0xYgwae/s-l1600.jpg");
			height: 620px;
		}
	</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
      <a class="navbar-brand" href="/">SPORT</a>
  	  <a class="navbar-brand navbar-right" href="/registration">Registration</a>
  </div>
</nav>
<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<form:form class="form-horizontal" action="/login" method="POST">
					<div class="form-group">
						<label class="control-label col-sm-2">Email:</label>
						<div class="col-sm-10">
							<input type="text" name="email" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" name="password" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox" name="rememberMe"/> Remember me</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-success" type="submit">Sing in</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
</div>
</body>
</html>