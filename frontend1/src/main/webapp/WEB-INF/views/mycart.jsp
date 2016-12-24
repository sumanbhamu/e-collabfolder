
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="header.jsp" %>
<body>
	<center>
		
		<h2>My Cart</h2>
		<h2>${cartpic11}</h2>
		<h2>${cartList}</h2>
		<h2>${cartvalue}</h2>
		
		<div class="container shadow"
		style="background-color: white; min-width: 860px">
	

		<!-- core tags ,if or choose  ,$-expression language -->

		<c:if test="${!empty cartvalue}">
			<table class="tg">
				<tr>
					<th>cart Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach items="${cartvalue}" var="cart">
					<tr>
						
						<td class="border" style="width: 120px"><img alt="${cartpic11}"
									src="resources/images/${cartpic11}.jpg"
									style="width: 100px; height: 100px"></td>
							
						<td>${cart.price}</td>
						<td>${cart.quantity}</td>
						<td><a
							href="<c:url value='/editcartcart${cart.id}'/>">Edit</a></td>
						<td><a
							href="<c:url value='/deletecartcart${cart.id}'/>">Delete</a></td>
					</tr>
				</c:forEach>


			</table>
			<br>
				<a href="main" class="btn btn-warning shadow"
					style="font-size: 17px">CONTINUE SHOPPING</a>
				<a href="placeorder${username}" class="btn btn-warning shadow"
					style="font-size: 17px; margin-left: 90px">PLACE ORDER</a>
			
		</c:if></div>
		<a href="viewproducts">Back</a>
<br>
<%@ include file="footer.jsp"%>
