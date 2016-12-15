<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<h2>Hello Admin</h2>

	<form:form method="POST" action="addsupp" commandName="supplier">
		<table>
			<tr>
				<td>Supplier Id</td>
				<td><form:input path="supplier_id" /></td>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><form:input path="supplier_name" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="supplier_address" /></td>
			</tr>
			
			<tr>
				<td colspan=2><input type="submit" value="Submit"
					style="color: green; font-size: 20pt;" /></td>
				<td><input type="reset" value="Cancel"
					style="color: red; font-size: 20pt" /></td>

			</tr>
		</table>
	</form:form>
</body>