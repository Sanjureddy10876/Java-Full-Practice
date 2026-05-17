<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Order</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .form-container {
        background: #fff;
        padding: 30px;
        border-radius: 12px;
        width: 350px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    input, select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 6px;
        border: 1px solid #ccc;
        outline: none;
    }

    input:focus, select:focus {
        border-color: #4facfe;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #4facfe;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background: #00c6ff;
    }
</style>

</head>

<body>

<div class="form-container">
    <h2>Order Food</h2>

    <form action="createNewOrder" method="post">
        
        <input type="text" name="foodName" placeholder="Food Name" required />

        <select name="foodtype" required>
            <option value="">Select Food Type</option>
            <option value="Veg">Veg</option>
            <option value="Non-Veg">Non-Veg</option>
        </select>

        <input type="text" name="orderedby" placeholder="Ordered By" required />

        <input type="text" name="phoneNumber" placeholder="Phone Number" required />

        <button type="submit">Place Order</button>
    </form>
</div>

</body>
</html>