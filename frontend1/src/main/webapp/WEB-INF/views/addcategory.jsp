<%@include file="adminhome.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>add category</title>
<style type="text/css">
.bg-grey {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 20px;
	width: 340px;
	height: 250px;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {

	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: blue;
	background-color: red;
}
</style>
</head>
<body>
<center>
	<h2>Add Category</h2>

	<div id="addcategory" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">

				<form:form method="POST" action="addcat" commandName="category">

					<table style="width: 300px; height: 200px; cellpadding: 20px;">
						<c:if test="${!empty category.cat_name}">
							<tr>
								<td><form:label path="cat_id">ID</form:label></td>
								<td><form:input path="cat_id" readonly="true" size="8"
										disabled="true" /> <form:hidden path="cat_id" /></td>
							</tr>
						</c:if>

						<tr>
							<td><form:label path="cat_name">Category-Name:</form:label></td>
							<td><form:input path="cat_name" /></td>
						</tr>
						<tr>
							<td><form:label path="description">Description:</form:label></td>
							<td><form:input path="description" /></td>
						</tr>
						<tr>
							<c:if test="${empty category.cat_name}">
								<td><input type="submit" value="Submit"
									style="color: blue; font-size: 13pt" /></td>
								<td><input type="reset" value="Cancle"
									style="color: red; font-size: 13pt" /></td>
							</c:if>

							<td colspan="2"><c:if test="${!empty category.cat_name}">
									<input type="submit" value="Edit category" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
</div>

	<br>
	<br>

	<h2>Category List</h2>
	<c:if test="${!empty categoryList}">
		<table class="tg">
			<tr>
				<th>Category Id</th>
				<th>Category Name</th>

				<th>Description</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.cat_id}</td>
					<td>${category.cat_name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='editcategory${category.cat_id}'/>">Edit</a></td>
					<td><a
						href="<c:url value='deletecategory${category.cat_id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<a href="adminhome">Back</a>


</body>
</html>