<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>

<style>
    body {
        font-family: Arial;
    }
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
    .total {
        font-size: 20px;
        text-align: right;
        margin-right: 10%;
    }
</style>

</head>
<body>

<h2 style="text-align:center;">Your Cart</h2>

<c:choose>

    <c:when test="${empty cartList}">
        <h3 style="text-align:center;">Cart is Empty</h3>
    </c:when>

    <c:otherwise>

        <table>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>

            <c:forEach var="cart" items="${cartList}">
                <tr>
                    <td>${cart.productEntity.name}</td>
                    <td>${cart.productEntity.price}</td>
                    <td>${cart.quantity}</td>
                    <td>
                        ${cart.productEntity.price * cart.quantity}
                    </td>
                </tr>
            </c:forEach>

        </table>

        <div class="total">
            <b>Grand Total:  ${totalAmount}</b>
        </div>
        <div>
        <button>Place order</button>
        </div>

    </c:otherwise>

</c:choose>

</body>
</html>