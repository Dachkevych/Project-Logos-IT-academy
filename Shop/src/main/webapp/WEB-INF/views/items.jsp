<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="/WEB-INF/tags/implicit.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/chosen.jquery.min.js"></script>
<title>Commodity main</title>
</head>
<style type="text/css">
		.buy{
			width: 100px;
			background-color: green;
			color: white;
		}
		.price{
			width: 120px;
			background-color: #fff3b5;
			margin: 20px;
			text-decoration: overline;
			height: 100px;
		}
		A:hover{
			text-decoration: none;
		}
</style>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
  	<div class="row">
  		<div class="col-sm-3">
  	  		<a class="navbar-brand" href="/">SPORT</a>
  	  	</div>
  	  	<div class="col-sm-9">
  	  	<sec:authorize access="!isAuthenticated()">
      		<a class="navbar-brand navbar-right" href="/login">Login</a>
      	</sec:authorize>
      	<sec:authorize access="isAuthenticated()">
			<form:form method="POST" action="/logout">
					<button type="submit" class="navbar-brand navbar-right btn btn-link">Logout</button>
			</form:form>
		</sec:authorize>
      	</div>
    </div>
  </div>
</nav>
<div class="container">
<div class="row">
<form:form class="form-horizontal" modelAttribute="commodity" action="/commodity/{id}" method="GET" >
<div class="col-sm-2 menu">
		</div>
			<div class="col-sm-10">
			<div class="col-sm-4">
				<a><img width="100%" alt="Commodity image" src="/images/${commodity.photoUrl}"></a>
			</div>
			<div class="col-sm-4">
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Brand: ${commodity.brand.name}</a></h4>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Gender: ${commodity.gender.name}</a></h4>
					</div>
				</div> 
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Category: ${commodity.category.name}</a></h4>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Color: ${commodity.color.name}</a></h4>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<h4><a >Season: ${commodity.season.name}</a></h4>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Material: ${commodity.material.name}</a></h4>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Size clothes: ${commodity.sizeClothes}</a></h4>
					</div>
				</div> 
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Size shoes: ${commodity.sizeShoes}</a></h4>
					</div>
				</div> 
				<div class="row">
					<div class="col-sm-8">
						<h4><a>Description: ${commodity.description}</a></h4>
					</div>
				</div> 
			</div>
			<div class="col-sm-4">
				<div class="rom"></div>
				<div class="row price">
					<div class="col-sm-8 ">
						<h3><a>${commodity.price}</a></h3>
					</div>
					<div class="row buttons">
							<div class="col-sm-12 text-center">
								<button class="btn buy glyphicon glyphicon-check" type="submit">Buy</button>
							</div>
						</div>
				</div> 
			</div>
		</div>
		</form:form>
	</div>
</div>
</body>
</html>