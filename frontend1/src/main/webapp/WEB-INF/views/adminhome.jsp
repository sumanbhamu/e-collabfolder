
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Home page</title>

<!-- adding predefined links of bootstrap -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




<!-- adding internal style to carousel -->
<style>
.navbar {
	background-color: lightgreen;
}

body {
	background-image: url("resources/images/aaa.jpg");
}
</style>
<body>
	<h4>welcome ${loggedInUser}</h4>


	<!-- adding menu bar(nav bar) -->
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home">Fashion Spot</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="home">Home</a></li>


				<li class="dropdown"><a class="dropdown-toggle" id="triangle"
					data-toggle="dropdown" href="addproduct">Products <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addproduct">Add</a></li>
						<li><a href="adminviewproducts">View All</a></li>

					</ul></li>



				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="addcategory">Category <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addcategory">Add</a></li>
						
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="addsupplier">Suppliers <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addsupplier">Add</a></li>
						
					</ul></li>


			</ul>
			<c:choose>

				<c:when test="${not empty loggedInUser}">

					<ul class="nav navbar-nav navbar-right">
						<li><a href="perform_logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</c:when>
			</c:choose>

		</div>
	</div>
	</nav>

	<!-- <div class="container"> -->