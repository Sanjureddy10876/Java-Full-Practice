<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Phone</title>

<style>
    body {
        font-family: Arial;
        background-color: #f2f2f2;
    }
    .form-container {
        width: 400px;
        margin: 50px auto;
        padding: 20px;
        background: white;
        border-radius: 10px;
        box-shadow: 0 0 10px #ccc;
    }
    input, select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
    }
    button {
        width: 100%;
        padding: 10px;
        background-color: green;
        color: white;
        border: none;
        cursor: pointer;
    }
</style>

</head>
<body>

<div class="form-container">
    <h2>Add Phone</h2>

    <form action="addPhone" method="post">
        
        <!-- Phone Name -->
        <input type="text" name="phoneName" placeholder="Enter Phone Name" required />

        <!-- Description -->
        <input type="text" name="phoneDescription" placeholder="Enter Description" required />

        <!-- Price -->
        <input type="number" name="price" placeholder="Enter Price" required />

        <!-- Quantity -->
        <input type="number" name="qty" placeholder="Enter Quantity" required />

        <!-- Currency Dropdown -->
        <select name="currencyType" required>
            <option value="">-- Select Currency --</option>
            <option value="INR">INR</option>
            <option value="USD">USD</option>
            <option value="EUR">EUR</option>
        </select>

        <!-- Submit Button -->
        <button type="submit">Add Phone</button>

    </form>
</div>

</body>
</html>