<!-- Using angular js -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>
<div>
	<div class="container">
		<div ng-app="myApp" ng-coontroller="dataCtrl">
			<hr>
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Quantity</th>
					<th>Product Image</th>
				</tr>
				<tr>
					<td>${product.prod_id }</td>
					<td>${product.prod_name }</td>
					<td>${product.prod_price }</td>
					<td>${product.quantity }</td>
					<!-- Individual product details -->

					<td><img src="resources/images/${product.prod_name}.jpg"
						style="height: 100px; width: 100px;"></td>
					<td><%-- <a href="buy${user_id}&${prod_id}">Add to cart</a> --%>
					
					<form  method="POST" action="buy${product.prod_id}" >
<input type="submit" value="Buy" class="btn btn-warning shadow" style="font-size:19px;margin:30px 30px"/>
</form>
					
					</td>
				</tr>

			</table>
			<center>
				<a href="viewproducts">Back</a>
			</center>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
