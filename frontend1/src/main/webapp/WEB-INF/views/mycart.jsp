
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="header.jsp" %>
<style>
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
	background-color: lightblue;
}


</style>

<body>
	<center>
		
		<h2>My Cart</h2>
		
		
		<div class="container shadow"
		style="background-color: white; min-width: 860px">
	

		<!-- core tags ,if or choose  ,$-expression language -->

		<c:if test="${!empty cartList}">
			<table class="tg">
				<tr>
					<th>cart Item</th>
					<th>Price</th>
					<th>Quantity</th>
					
				</tr>

				<c:forEach items="${cartList}" var="cart">
					<tr>
						
						<td class="border" style="width: 120px"><img alt="${cartpic11}"
									src="resources/images/${cart.cartproduct.prod_name}.jpg"
									style="width: 100px; height: 100px"></td>
							
						<td>${cart.price}</td>
						<td>${cart.quantity}</td>
						<%-- <td><a
							href="<c:url value='/editcartcart${cart.id}'/>">Edit</a></td>
						<td><a
							href="<c:url value='/deletecartcart${cart.id}'/>">Delete</a></td> --%>
					</tr>
				</c:forEach>
			</table><br><br>
			
			<h3> Total price: ${Total}</h3><br>
			
				<a href="bill" class="btn btn-warning shadow"
					style="font-size: 17px">CHECK OUT</a>
				
		</c:if></div>
		<!-- <a href="viewproducts">Back</a> -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="footer.jsp"%>
