<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Snapdeal Partner Portal | Add Product</title>
<style>
    :root {
        --myntra-pink: #ff3f6c;
        --text-main: #282c3f;
        --text-light: #94969f;
        --border-color: #d4d5d9;
    }

    body {
        font-family: "Assistant", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
        background-color: #fff;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        color: var(--text-main);
    }

    .form-wrapper {
        width: 100%;
        max-width: 400px;
        padding: 40px;
        border: 1px solid #f5f5f6;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
    }

    h2 {
        font-size: 24px;
        font-weight: 700;
        margin-bottom: 30px;
        text-transform: uppercase;
        letter-spacing: 1px;
        color: var(--text-main);
        border-bottom: 2px solid var(--myntra-pink);
        display: inline-block;
        padding-bottom: 5px;
    }

    .input-group {
        margin-bottom: 20px;
        position: relative;
    }

    label {
        display: block;
        font-size: 12px;
        font-weight: 600;
        color: var(--text-light);
        margin-bottom: 8px;
        text-transform: uppercase;
    }

    input[type="text"] {
        width: 100%;
        padding: 12px 0;
        border: none;
        border-bottom: 1px solid var(--border-color);
        outline: none;
        font-size: 14px;
        transition: border-color 0.3s;
        background: transparent;
    }

    input[type="text"]:focus {
        border-bottom: 1px solid var(--text-main);
    }

    input[type="submit"] {
        width: 100%;
        background-color: var(--myntra-pink);
        color: white;
        border: none;
        padding: 15px;
        font-size: 14px;
        font-weight: 700;
        text-transform: uppercase;
        cursor: pointer;
        margin-top: 20px;
        border-radius: 2px;
        letter-spacing: 1px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #ec3d63;
    }

    .brand-header {
        position: absolute;
        top: 30px;
        left: 30px;
        font-weight: 900;
        font-size: 20px;
        color: var(--myntra-pink);
    }
</style>
</head>
<body>

    <div class="brand-header">SNAPDEAL</div>

    <div class="form-wrapper">
        <h2>Add Product</h2>

        <form action="products" method="post">
            
            <div class="input-group">
                <label>Product Name</label>
                <input type="text" name="productName" placeholder="e.g. Slim Fit Casual Shirt">
            </div>

            <div class="input-group">
                <label>Description</label>
                <input type="text" name="description" placeholder="Material, Fit, Care info">
            </div>

            <div class="input-group">
                <label>Price (INR)</label>
                <input type="text" name="price" placeholder="0.00">
            </div>

            <div class="input-group">
                <label>Stock Quantity</label>
                <input type="text" name="qty" placeholder="Units available">
            </div>

            <input type="submit" value="Add Product">

        </form>
          <form action="getAllProducts" method="get">

            <input type="submit" value="Get All Products">

        </form>
    </div>

</body>
</html>