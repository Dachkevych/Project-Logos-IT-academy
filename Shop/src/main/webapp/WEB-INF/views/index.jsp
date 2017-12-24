<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="/WEB-INF/tags/implicit.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/chosen.jquery.min.js"></script>
<script>
	$(function(){
		$('select').chosen({width:'100%'});
	})
</script>
<title>SportShop</title>
	<style type="text/css">
		.view{
		}
		.dropdown:hover .dropdown-menu {
    		display: block;
		}
		/*  .border{
			border: 2px solid grey;
			background-color: #F0F8FF;
			padding: 0;
			height: 100%;
		} */
		.border:hover{
			background-color: #F2F2F2; 
		}
		.image{
			margin: 10px;
			height: 300px;
		}
		.buttons{
			margin-bottom: 10px;
			margin-right: 20px;
		}
		.buy{
			margin-left: 80px;
		}
		.items{
			margin: 20px;
		}
		A:hover{
			text-decoration: none;
		}
		.submenu
		{
 		   display: none;   
 		   position: inherit;
 		   text-align: left;
  		   background-color: white;
  		   padding: 5px;border: 1px solid #6B93FF;
		}

		div.main_menu_item:hover div
		{
    	   display: inline-block;
		}
		.menu{
			border: 1px solid grey; 
		}
		.menu.h3{
			background-color: red;
		}
		.submenu{
			width: 165px;
		}
		.right{
			padding-left: 70px;
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
  	  	<sec:authorize access="hasRole('ROLE_ADMIN')">
  	  		<a class="navbar-brand navbar-right" href="/admin/commodity">Add commodity</a>
  	  	</sec:authorize>
  	  	<sec:authorize access="!isAuthenticated()">
      		<a class="navbar-brand navbar-right" href="/login">Login</a>
      	</sec:authorize>
      	<sec:authorize access="isAuthenticated()">
		<form:form action="/user">
				<button type="submit" class="navbar-brand navbar-right btn btn-link">Office</button>
		</form:form>
		</sec:authorize>
      	</div>
    </div>
  </div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-sm-2 menu">
			<h3>Clothes</h3>
			<a href="">T-Shirt</a><br>
			<a href="">Short</a><br>
			<a href="">Suit</a><br>
			<a href="">Jeans</a><br>
			<a href="">Skirts</a><br>
			<a href="">Jumpsuits</a><br>
			<a href="">Leggings </a><br>
			<a href="">Jackets</a><br>
			<a href="">Sweaters</a><br>
			<h3>Shoes</h3>
			<a href="">Sports Shoes</a><br>
			<a href="">Sneakers</a><br>
			<a href="">Boots</a><br>
			<a href="">Floaters</a><br>
			<a href="">Flats</a><br>
			<a href="">Sandals</a><br>
			<a href="">Heels</a><br>
			<h3>ACCESSORIES</h3>
			<a href="">Watches</a><br>
			<a href="">Sunglasses</a><br>
			<a href="">Eye Glasses</a><br>
			<a href="">Belts</a><br>
		</div>
		<div class="col-sm-10 view">
			<c:forEach var="commodity" items="${commodities.content}">
				<div class="col-sm-4" href="/commodity/${commodity.id}">
					<div class="col-sm-12 border">
						<div class="row image">
							<a href="/commodity/${commodity.id}"><img width="100%" alt="Commodity image" src="/images/${commodity.photoUrl}"></a>
						</div>
						<div class="row text-center">
							<h4><a href="/commodity/${commodity.id}">Category: ${commodity.category}</a></h4>
							<h4><a href="/commodity/${commodity.id}">Brand: ${commodity.brand}</a></h4>
							<h4><a href="/commodity/${commodity.id}">Price: ${commodity.price}</a></h4>
						</div>
						 <sec:authorize access="isAuthenticated()">
						 <form:form modelAttribute="/" method="POST">
						<div class="row buttons">
							<div class="col-sm-12">
								<button class="btn buy" type="submit">Add to cart</button>
							</div>
						</div>
						</form:form>
						</sec:authorize>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>
