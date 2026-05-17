<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Snapdeal | Shop</title>

<style>
    /* Myntra-inspired design system */
    :root {
        --myntra-pink: #ff3f6c;
        --myntra-dark: #282c3f;
        --myntra-gray: #94969f;
        --bg-color: #ffffff;
        --border-light: #eaeaec;
    }

    body {
        font-family: "Assistant", -apple-system, sans-serif;
        background-color: var(--bg-color);
        margin: 0;
        padding: 0;
        color: var(--myntra-dark);
    }

    /* Top Navigation Style Bar */
    .header-controls {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 15px 10%;
        background: white;
        box-shadow: 0 4px 12px 0 rgba(0,0,0,.05);
        margin-bottom: 30px;
        position: sticky;
        top: 0;
        z-index: 100;
    }

    .brand-logo {
        font-weight: 900;
        font-size: 24px;
        color: var(--myntra-dark);
        letter-spacing: 1px;
    }

    .search-container {
        display: flex;
        border: 1px solid var(--border-light);
        background: #f5f5f6;
        border-radius: 4px;
        width: 40%;
    }

    input[type="text"] {
        padding: 10px 15px;
        border: none;
        background: transparent;
        width: 100%;
        outline: none;
        font-size: 14px;
    }

    .search-btn {
        padding: 10px 20px;
        background-color: transparent;
        color: var(--myntra-dark);
        border: none;
        cursor: pointer;
        font-weight: 700;
        font-size: 12px;
        text-transform: uppercase;
    }

    /* Product Grid Styling */
    .product-grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
        gap: 30px;
        max-width: 1300px;
        margin: 0 auto;
        padding: 0 20px;
    }

    /* Card Design */
    .product-card {
        background: white;
        display: flex;
        flex-direction: column;
        transition: box-shadow 0.3s ease;
        position: relative;
    }

    .product-card:hover {
        box-shadow: 0 7px 15px 0 rgba(0,0,0,.1);
    }

    /* Image area like a fashion thumbnail */
    .image-placeholder {
        background: #f9f9f9;
        height: 280px;
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: hidden;
    }

    .card-content {
        padding: 12px;
        text-align: left;
    }

    .product-name {
        font-size: 16px;
        font-weight: 700;
        color: var(--myntra-dark);
        margin-bottom: 5px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .price-tag {
        font-size: 16px;
        color: var(--myntra-dark);
        font-weight: 700;
        margin: 8px 0;
    }

    .stock-info {
        font-size: 12px;
        color: #ff905a; /* Myntra orange for stock warnings */
        margin-bottom: 12px;
        font-weight: 600;
        text-transform: uppercase;
    }

    .out-of-stock-text {
        color: var(--myntra-gray);
        font-weight: 600;
    }

    /* Action Buttons */
    .qty-container {
        display: flex;
        align-items: center;
        gap: 10px;
        margin-bottom: 10px;
    }

    .qty-input {
        width: 45px;
        padding: 4px;
        border: 1px solid var(--border-light);
        border-radius: 2px;
        text-align: center;
    }

    .add-btn {
        background-color: var(--myntra-pink);
        color: white;
        border: none;
        padding: 12px;
        width: 100%;
        cursor: pointer;
        font-size: 12px;
        font-weight: 700;
        text-transform: uppercase;
        border-radius: 2px;
        letter-spacing: 1px;
    }

    .add-btn:hover {
        background-color: #ec3d63;
    }

    .disabled-btn {
        background-color: #fff;
        border: 1px solid var(--border-light);
        color: var(--myntra-gray);
        padding: 12px;
        width: 100%;
        cursor: not-allowed;
        font-size: 12px;
        font-weight: 700;
        text-transform: uppercase;
        border-radius: 2px;
    }
</style>
</head>

<body>

    <div class="header-controls">
        <div class="brand-logo">SNAPDEAL</div>
        
        <div class="search-container">
            <form action="searchProducts" method="get" style="display:flex; width: 100%;">
                <input type="text" name="searchProductByName" placeholder="Search for brands, products and more">
                <button type="submit" class="search-btn">Search</button>
            </form>
        </div>
<!-- 
        <form action="getAllProducts" method="get">
            <input type="submit" value="All Products" style="background:none; border:none; cursor:pointer; font-weight:700; color:var(--myntra-dark);">
        </form> -->
        <form action="viewCart" method="get">
            <input type="submit" value="View Cart" style="background:none; border:none; cursor:pointer; font-weight:700; color:var(--myntra-dark);">
        </form>
    </div>

    <h3 style="text-align: center; color: var(--myntra-pink);">${response.confirmMsg}</h3>

    <div class="product-grid">
        <c:if test="${empty productList}">
            <p style="grid-column: 1/-1; text-align: center;">No products found.</p>
        </c:if>

        <c:forEach var="p" items="${productList}">
            <div class="product-card">
                <div class="image-placeholder">
                    <span style="color: #d4d5d9; font-size: 12px; font-weight: 600;">NO PREVIEW</span>
                </div>

                <div class="card-content">
                    <div class="product-name">
                        <c:out value="${p.productName}" default="Unnamed Product" />
                    </div>

                    <div class="price-tag">
                        Rs. 
                        <c:choose>
                            <c:when test="${not empty p.priceEntity}">${p.priceEntity.price}</c:when>
                            <c:otherwise>0.00</c:otherwise>
                        </c:choose>
                    </div>

                    <div class="stock-info">
                        <c:choose>
                            <c:when test="${not empty p.inventryEntity && p.inventryEntity.avaliable_qty > 0}">
                                Only ${p.inventryEntity.avaliable_qty} left!
                            </c:when>
                            <c:otherwise>
                                <span class="out-of-stock-text">Currently Unavailable</span>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div style="margin-top: auto;">
                        <c:choose>
                        
                            <c:when test="${not empty p.inventryEntity && p.inventryEntity.avaliable_qty > 0}">
                                <form action="addToCart" method="post">
                                    <input type="hidden" name="productId" value="${p.productID}">
                                    <div class="qty-container">
                                        <label style="font-size: 11px; color: var(--myntra-gray);">QTY:</label>
                                        <input type="number" name="quantity" value="1" min="1" max="${p.inventryEntity.avaliable_qty}" class="qty-input">
                                    </div>
                                    <button type="submit" class="add-btn">Add to Bag</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <button disabled class="disabled-btn">Out of Stock</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</body>
</html>