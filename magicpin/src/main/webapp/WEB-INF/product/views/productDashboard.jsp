<%@page import="com.magicpin.entity.ProductEntity"%>
<%@ page import="java.util.List"%>
<%@ page import="com.magicpin.entity.ProductEntity"%>


<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Dashboard</title>

<style>
body {
	font-family: Arial;
}

.section {
	border: 1px solid #ccc;
	padding: 15px;
	margin: 15px;
	border-radius: 8px;
}

h2 {
	color: #ff416c;
}

input, button {
	margin: 5px;
	padding: 8px;
}
</style>
</head>
<body>

	<h1>Product Management Dashboard</h1>

	<div class="section">
		<h2>Add Product</h2>
		<form action="addProduct" method="post">
			<input type="text" name="name" placeholder="Name" required /> <input
				type="text" name="category" placeholder="Category" required /> <input
				type="number" step="0.01" name="price" placeholder="Price" required />
			<input type="text" name="quantity" placeholder="Quantity" required />
			<input type="text" name="description" placeholder="Description" />
			<button type="submit">Add</button>
		</form>
	</div>

	<c:if test="${not empty editProduct}">
		<div class="section">
			<h2>Update Product</h2>

			<form action="updateProduct" method="post">
				<input type="text" name="id" value="${editProduct.id}" readonly />

				<input type="text" name="name" value="${editProduct.name}" /> <input
					type="number" step="0.01" name="price" value="${editProduct.price}" />

				<button type="submit">Update</button>
			</form>
		</div>
	</c:if>
	<div class="section">
		<h2>Search Product</h2>
		<form action="searchProduct" method="get">
			<input type="text" name="name" placeholder="Product Name" required />
			<button type="submit">Search</button>
		</form>
	</div>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="section">
		<h2>Products</h2>

		<!-- Buttons -->
		<form action="viewProducts" method="get">
			<button type="submit" name="status" value="ACTIVE">Active
				Products</button>
			<button type="submit" name="status" value="INACTIVE">Inactive
				Products</button>
		</form>

		<br>

		<!-- Table -->
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Description</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<!-- If list is empty -->
			<c:if test="${empty products}">
				<tr>
					<td colspan="5">No products found</td>
				</tr>
			</c:if>

			<!-- Loop -->
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.name}</td>
					<td>${p.category}</td>
					<td>${p.price}</td>
					<td>${p.quantity}</td>
					<td>${p.description}</td>
					<td>
						<form action="editProduct" method="get">
							<input type="hidden" name="id" value="${p.id}" />
							<button type="submit">Update</button>
						</form>
					</td>

					<td>
						<form action="deleteProduct" method="post">
							<input type="hidden" name="id" value="${p.id}" />

							<c:choose>
								<c:when test="${p.status eq 'ACTIVE'}">
									<input type="hidden" name="status" value="INACTIVE" />
									<button type="submit">Delete</button>
								</c:when>

								<c:otherwise>
									<input type="hidden" name="status" value="ACTIVE" />
									<button type="submit">Restore</button>
								</c:otherwise>
							</c:choose>

						</form>
					</td>
				</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>