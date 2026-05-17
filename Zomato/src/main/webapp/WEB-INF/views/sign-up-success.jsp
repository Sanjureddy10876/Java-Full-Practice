<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zomato - Welcome</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        background: linear-gradient(rgba(0,0,0,0.8), rgba(0,0,0,0.8)),
                    url('https://images.unsplash.com/photo-1504674900247-0877df9cc836');
        background-size: cover;
        background-position: center;
        color: white;
        padding: 20px;
    }

    .header {
        text-align: center;
        margin-bottom: 30px;
    }

    .header h1 {
        font-size: 40px;
        color: #ff4d4d;
        letter-spacing: 2px;
    }

    .success {
        text-align: center;
        margin-bottom: 30px;
    }

    .success h2 {
        color: #4CAF50;
        margin-bottom: 10px;
    }

    .card {
        background: rgba(255,255,255,0.1);
        padding: 20px;
        border-radius: 15px;
        margin-bottom: 20px;
        backdrop-filter: blur(10px);
        box-shadow: 0 5px 20px rgba(0,0,0,0.3);
    }

    .card h3 {
        color: #ff4d4d;
        margin-bottom: 10px;
    }

    .info {
        font-size: 15px;
        margin: 5px 0;
        color: #ddd;
    }

    .btn {
        display: block;
        width: 100%;
        padding: 14px;
        border: none;
        border-radius: 25px;
        background: #ff4d4d;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        margin-top: 20px;
        transition: 0.3s;
        color: white;
    }

    .btn:hover {
        background: #e60023;
        transform: scale(1.03);
    }

</style>

</head>

<body>

<div class="header">
    <h1>ZOMATO</h1>
</div>

<div class="success">
    <h2>✅ Sign Up Successful!</h2>
    <p>Welcome, Santhosh 👋</p>
</div>

<div class="card">
    <h3>👤 Profile Details</h3>
    <div class="info">Mobile: 9876543210</div>
    <div class="info">Email: santhosh@example.com</div>
    <div class="info">Location: Bangalore</div>
</div>

<div class="card">
    <h3>🍔 Recent Order</h3>
    <div class="info">Restaurant: Paradise Biryani</div>
    <div class="info">Items: Chicken Biryani + Coke</div>
    <div class="info">Amount: ₹299</div>
    <div class="info">Delivery Time: 25 mins</div>
</div>

<div class="card">
    <h3>💳 Zomato Wallet</h3>
    <div class="info">Balance: ₹350</div>
    <div class="info">Zomato Credits: ₹120</div>
</div>

<form action="showLogin">
    <button class="btn">Explore Food →</button>
</form>

</body>
</html>