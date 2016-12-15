
<%@include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
body {
	background-image: url("resources/images/aaa.jpg");
}

td {
	font-size: 20px;
}
</style>



<center>
	<h1>Registration</h1>
	<p>
		ALREADY REGISTERED? <a href="login">SIGN IN</a>
	</p>

	<form:form commandName="us">

		<table>
			<tr>
				<td>Name</td>
				<td><form:input type="text" path="username" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('username')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td>Enter Password</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td>Enter Confirmed Password</td>
				<td><form:input type="password" path="confirmpassword" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
			<tr>
				<td>Email Id</td>
				<td><form:input type="email" path="emailid" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>



			<tr>
				<td>Phone no.</td>
				<td><form:input type="text" path="phno" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('phno')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>



			<tr>
				<td><input type="CHECKBOX" NAME="OFFER" CHECKED>I agree
					to receive information about exciting offers</td>
			</tr>
		</table>

		<br />
		<br />


		<div class="center">
			<input type="submit" name="_eventId_submit" value="submit">
		</div>

	</form:form>
	<br> <img src="resources/images/pic20.jpg" width="1000"
		height="300"></img>

</center>
<br />
<%@ include file="footer.jsp"%>







