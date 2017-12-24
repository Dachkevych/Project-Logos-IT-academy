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
<script>
	$(function(){
		$('select').chosen({width:'100%'});
	})
</script>
<title>Commodity</title>
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
<div class="container">
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<div class="row">
		<div class="col-sm-12">
			<form:form class="form-horizontal" modelAttribute="commodity" action="/admin/commodity" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label for="category" class="control-label col-sm-2">Category</label>
							<div class="col-sm-10">
								<form:select  path="category" id="category" class="form-control">
									<c:forEach items="${categorys}" var="category">
										<option value="${category.id}">${category.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="brand" class="control-label col-sm-2">Brand</label>
							<div class="col-sm-10">
								<form:select  path="brand" id="brand" class="form-control">
									<c:forEach items="${brands}" var="brand">
										<option value="${brand.id}">${brand.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="control-label col-sm-2">Gender</label>
							<div class="col-sm-10">
								<form:select  path="gender" id="gender" class="form-control">
									<c:forEach items="${genders}" var="gender">
										<option value="${gender.id}">${gender.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="color" class="control-label col-sm-2">Color</label>
							<div class="col-sm-10">
								<form:select  path="color" id="color" class="form-control">
									<c:forEach items="${colors}" var="color">
										<option value="${color.id}">${color.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="season" class="control-label col-sm-2">Season</label>
							<div class="col-sm-10">
								<form:select  path="season" id="season" class="form-control">
									<c:forEach items="${seasons}" var="season">
										<option value="${season.id}">${season.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="material" class="control-label col-sm-2">Material</label>
							<div class="col-sm-10">
								<form:select  path="material" id="material" class="form-control">
									<c:forEach items="${materials}" var="material">
										<option value="${material.id}">${material.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="sizeClothes" class="control-label col-sm-2">Size Clothes:</label>
							<div class="col-sm-10">
                            	<form:select path="sizeClothes" items="${sizeClotheses}" itemLabel="value" class="form-control" />
                        	</div>
						</div>
						<div class="form-group">
							<label for="sizeShoes" class="control-label col-sm-2">Size Shoes:</label>
							 <div class="col-sm-10">
                            	<form:select path="sizeShoes" items="${sizeShoeses}" itemLabel="value" class="form-control" />
                        	</div>
						</div>
						<div class="form-group">
							<label for="price" class="control-label col-sm-2">Price:</label>
							<div class="col-sm-10">
								<form:input type="text" path="price" id="price" class="form-control"/> 
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="control-label col-sm-2">Description:</label>
							<div class="col-sm-10">
								<form:input path="description" id="description" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label for="file" class="control-label col-sm-2">Select img:</label>
							<div class="col-sm-10">
								<form:input path="file" id="file" type="file"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-success" type="submit">Create</button>
							</div>
						</div>
						</form:form>
					</div>
				</div>
		</sec:authorize>
		<div class="row">
			<div class="col-sm-12">
					<table class="table table-bordered">
						<tr>
							<th>Photo</th>
							<th>Category</th>
							<th>Brand</th>
							<th>Gender</th>
							<th>Color</th>
							<th>Season</th>
							<th>Material</th>
							<th>Size Clothes</th>
							<th>Size Shoes</th>
							<th>Price</th>
							<th>Description</th>
							<th>Update</th>
							<th>Delete</th>
						</tr>
						<c:forEach var="commodity"  items="${commodities.content}">
						<tr>
							<td><img width="100%" alt="Commodity image" src="/images/${commodity.photoUrl}"></td>							
							<td>${commodity.category.name}</td>
							<td>${commodity.brand.name}</td>
							<td>${commodity.gender.name}</td> 
							<td>${commodity.color.name}</td>
							<td>${commodity.season.name}</td>
							<td>${commodity.material.name}</td>
							<td>${commodity.sizeClothes}</td>
							<td>${commodity.sizeShoes}</td>
							<td>${commodity.price}</td>
							<td>${commodity.description}</td>
							<td class="text-center"><a href="/admin/commodity/update/${commodity.id}" class="btn btn-warning">Update</a></td>
							<td class="text-center"><a href="/admin/commodity/delete/${commodity.id}" class="btn btn-danger">Delete</a></td>
						</tr>
						</c:forEach>
					</table>
					</div>
					</div>
		</div>
</body>
</html>