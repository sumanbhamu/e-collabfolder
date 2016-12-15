
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


</head>
<body>
<td>welcome ${loggedInUser}</td>
						
	<!-- adding menu bar(nav bar) -->
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index">Fashion Spot</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index">Home</a></li>
				<li><a href="aboutus">About Us</a></li>
				<li><a href="viewproducts">Products</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty loggedInUser}">
						<li><a href="memberShip.obj"><span
								class="glyphicon glyphicon-user"></span> Sign-up</a></li>

						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>

					</c:when>
					
					<c:when test="${not empty loggedInUser}">
						<li><a href="perform_logout"><span
								class="glyphicon glyphicon-log-out"> </span>Logout</a></li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</div>
	</nav>