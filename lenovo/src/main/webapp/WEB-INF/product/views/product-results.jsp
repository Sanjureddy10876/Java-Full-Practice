<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style>
    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid black;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>

<h2 style="text-align:center;">Product List</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Timestamp</th>
        <th>Delete</th>
    </tr>

 <c:forEach var="product" items="${response}">
    <tr>
        <td>${product.productID}</td>
        <td>${product.productName}</td>
        <td>${product.productDescription}</td>
        <td>${product.status}</td>
        <td>${product.timestap}</td>

        <td>
            <form action="deleteProduct" method="post">
                <input type="hidden" name="productID" value="${product.productID}" />
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
</c:forEach>

</table>

</body>
</html>