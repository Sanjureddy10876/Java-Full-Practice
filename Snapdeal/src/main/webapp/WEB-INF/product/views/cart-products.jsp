<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f6;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 70%;
        margin: 30px auto;
    }

    h2 {
        margin-bottom: 20px;
    }

    .cart-card {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background: #fff;
        padding: 15px;
        margin-bottom: 15px;
        border-radius: 8px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }

    .product-info {
        flex: 2;
    }

    .price-info {
        flex: 1;
        text-align: right;
    }

    .status {
        font-weight: bold;
        margin-top: 5px;
    }

    .available {
        color: green;
    }

    .out {
        color: red;
    }

    .total-box {
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        margin-top: 20px;
        text-align: right;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }

    .btn {
        background-color: #ff3f6c;
        color: white;
        padding: 12px 25px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        margin-top: 10px;
    }

    .btn:hover {
        background-color: #e0355f;
    }

    .remove-btn {
        background-color: transparent;
        border: 1px solid #ff3f6c;
        color: #ff3f6c;
        padding: 6px 12px;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 8px;
    }

    .remove-btn:hover {
        background-color: #ff3f6c;
        color: white;
    }

    .empty {
        text-align: center;
        background: #fff;
        padding: 30px;
        border-radius: 8px;
    }
</style>

</head>

<body>

<div class="container">

    <h2>Snapdeal Shopping Cart</h2>

    <!-- ✅ EMPTY CART -->
    <c:if test="${empty cartItems}">
        <div class="empty">
            <h3>Your cart is empty</h3>
        </div>
    </c:if>

    <!-- ✅ TOTAL INIT -->
    <c:set var="total" value="0"/>

    <!-- ✅ CART ITEMS -->
    <c:forEach var="item" items="${cartItems}">

        <div class="cart-card">

            <!-- LEFT SIDE -->
            <div class="product-info">
                <p><b>${item.product.productName}</b></p>
                <p>Quantity: ${item.quantity}</p>

                <!-- STOCK STATUS -->
                <c:choose>
                    <c:when test="${item.product.inventryEntity.avaliable_qty >= item.quantity}">
                        <p class="status available">Available</p>
                    </c:when>
                    <c:otherwise>
                        <p class="status out">Out of stock</p>
                    </c:otherwise>
                </c:choose>

                <!-- ✅ DELETE BUTTON -->
                <form action="removeItem" method="post">
                    <input type="hidden" name="productId" value="${item.product.productID}" />
                    <button class="remove-btn" type="submit">Remove</button>
                </form>

            </div>

            <!-- RIGHT SIDE -->
            <div class="price-info">
                <p>Price: ${item.product.priceEntity.price}</p>
                <p><b>Subtotal: ${item.product.priceEntity.price * item.quantity}</b></p>
            </div>

        </div>

        <!-- ✅ TOTAL CALCULATION -->
        <c:set var="total" 
               value="${total + (item.product.priceEntity.price * item.quantity)}"/>

    </c:forEach>

    <!-- ✅ TOTAL + ORDER -->
    <c:if test="${not empty cartItems}">
        <div class="total-box">
            <h3>Total: ${total}</h3>

            <form action="placeOrder" method="post">
                <button class="btn" type="submit">Place Order</button>
            </form>
        </div>
    </c:if>

</div>

</body>
</html>