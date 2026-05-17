<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="section">
		<h2>Products</h2>

		<!-- Buttons -->
		<form action="viewAll" method="get">


			<br>

			<!-- Table -->
			<table border="1">
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Description</th>
					<th>Quantity</th>
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
							<form action="addToCart" method="post">
								<input type="hidden" name="productId" value="${p.id}" />
								Quantity : <input type="number" name="quantity" value="1" min="1"></>
								<button type="submit">Add to Cart</button>
							</form>
						</td>

					</tr>

				</c:forEach>

			</table>
	</div>
</body>
</html>