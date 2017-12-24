<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tags/implicit.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<title>Brand</title>
<style type="text/css">
		body{
			background-color: 	#EBEBEB;
		}
		.search{
			
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
      <div class="col-sm-2 navbar-nav navbar-right">
      	<form:form class="form-horizontal" modelAttribute="filter" action="/admin/brand/" method="GET">
			<div class="form-group">
				<div class="col-sm-12">
					<form:input placeholder="Search" path="search" class="form-control"/>
				</div>
			</div>
		</form:form>
	  </div>		
      <sec:authorize access="isAuthenticated()">
		<form:form action="/logout">
				<button type="submit" class="navbar-brand navbar-right btn btn-link">Logout</button>
		</form:form>
	</sec:authorize>
    </div>
</nav>
<h2 class="text-center">Brand</h2>
	<div class="container" >
		<div class="row">
		<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<form:form class="form-horizontal" modelAttribute="brand" action="/admin/brand/" method="POST">
					<div class="form-group">
							<label for="name" class="control-lable col-sm-2 text-center" >Name</label>
						<div class="col-sm-8">
							<form:input type="text" path="name" id="name" class="form-control"/>
						</div>
						<div class="col-sm-2 ">
							<button class="btn btn-success" type="submit">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
		<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<table width="100%" class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Update</th>
						<th class="text-center">Delete</th>
					</tr>
					<c:forEach items="${brands.content}" var="brand">
					<tr>
						<td class="text-center">${brand.name}</td>
						<td class="text-center"><a href="/admin/brand/update/${brand.id}" class="btn btn-warning">Update</a></td>
						<td class="text-center"><a href="/admin/brand/delete/${brand.id}" class="btn btn-danger">Delete</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-2">
				<div class="row">
					<div class="col-xs-12">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="A-Z" paramValue="name" />
								<custom:sort innerHtml="Z-A" paramValue="name,desc" />
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- <div class="row">
		<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${brands}" cell="<li></li>" container="<ul class='pagination'></ul>" />
		</div>
	</div> --%>
	<div class="row">
	<div class="col-sm-8">
	</div>
		<div class="col-sm-2">
			<button class="btn btn-success">
				<a href="/admin">Back</a>
			</button>
		</div>
	</div>
</body>
</html>