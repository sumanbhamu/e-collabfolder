<%@ include file="header.jsp"%>
<h1>${cartpic11}</h1>
<table>
  <tr>
 
<td class="border" style="width: 120px"><img alt="${cartpic11}"
									src="resources/images/${cartpic11}.jpg"
									style="width: 100px; height: 100px"></td>
							


<td><a class="col-xs-offset-5 btn btn-lg btn-success" href="cart_checkout">Checkout</a></td>


</tr>



</table>































<%-- 
<%@ include file="header.jsp"%>
<br>
<center>
	<div class="container shadow"
		style="background-color: white; min-width: 860px">
		<c:if test="${!empty cartmessage1}">
			<p style="margin-top: 10px; background-color: #F3E690">${cartmessage1}</p>
		</c:if>
		<c:choose>
			<c:when test="${!empty mycartList}">
				<p style="margin-top: 10px">
					<b style="font-size: 17px">MY CART</b>
				</p>
				<table class="border" style="width: 810px; margin-top: 8px">
					<tr
						style="background-color: #F3E5E5; font-size: 19px; text-align: center">
						<td class="border" colspan="2">ITEM</td>
						<td class="border">QTY</td>
						<td class="border">Price</td>
						<td class="border">Edit</td>
						<td class="border">Delete</td>
					</tr>
					<c:forEach items="${mycartList}" var="cart">
						<tr style="height: 120px; text-align: center">
							<td class="border" style="width: 120px"><a
								href="productselect${cart.cartproduct.prod_id}"><img
									src="resources/images/${cart.cartproduct.prod_name}.jpg"
									style="width: 100px; height: 100px"></a></td>
							<td class="border"><span style="font-size: 17px">${cart.cartproduct.prod_name}</span>
								<br>
							<td class="border"><c:choose>
									<c:when test="${!empty editcartid}">
										<c:if test="${cart.id == editcartid }">
											<form method="POST" action="updatecartquan${cart.id}">
												<input type="number" name="quantity" style="width: 33px"
													value="${cart.quantity}" /><br> <input type="submit"
													class="btn btn-primary shadow" style="height: 33px"
													value="Save" />
											</form>
										</c:if>
									</c:when>
									<c:otherwise>
										${cart.quantity}
</c:otherwise>
								</c:choose></td>
							<td class="border">${cart.price}</td>
							<td><a href="<c:url value='cartupdate${cart.id}'/>"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="<c:url value='cartitemdelete${cart.id}'/>"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
					<tr class="border" style="height: 40px">
						<td colspan="4" style="text-align: right; font-size: 19px">Amount
							Payable: Rs.${cartprice}&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
				<br>
				<a href="main" class="btn btn-primary shadow"
					style="font-size: 17px">CONTINUE SHOPPING</a>
				<a href="placeorder${username}" class="btn btn-warning shadow"
					style="font-size: 17px; margin-left: 90px">PLACE ORDER</a>

			</c:when>
			<c:otherwise>
				<br>
				<span style="font-size: 19px">No Products in your Cart</span>
				<br>
				<a href="main" class="btn btn-primary shadow"
					style="font-size: 17px; margin-top: 10px">CONTINUE SHOPPING</a>
			</c:otherwise>
		</c:choose>
		<br> <br>
	</div>
</center>
<br>
<%@ include file="footer.jsp"%>
 --%>