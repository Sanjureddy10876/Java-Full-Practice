<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zomato Sign Up</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        height: 100vh;
        background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)),
                    url('https://images.unsplash.com/photo-1504674900247-0877df9cc836');
        background-size: cover;
        background-position: center;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: rgba(255, 255, 255, 0.1);
        padding: 40px;
        border-radius: 20px;
        backdrop-filter: blur(15px);
        width: 360px;
        color: white;
        box-shadow: 0 8px 32px rgba(0,0,0,0.3);
        text-align: center;
    }

    .container h2 {
        margin-bottom: 25px;
        font-size: 30px;
        letter-spacing: 2px;
        color: #ff4d4d;
    }

    .input-box {
        margin-bottom: 18px;
        text-align: left;
    }

    .input-box label {
        font-size: 14px;
        margin-bottom: 5px;
        display: block;
        color: #ddd;
    }

    .input-box input {
        width: 100%;
        padding: 12px;
        border-radius: 10px;
        border: none;
        outline: none;
        font-size: 15px;
    }

    .input-box input:focus {
        box-shadow: 0 0 8px #ff4d4d;
    }

    .btn {
        width: 100%;
        padding: 14px;
        border: none;
        border-radius: 25px;
        background: #ff4d4d;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
        margin-top: 10px;
        color: white;
    }

    .btn:hover {
        background: #e60023;
        transform: scale(1.05);
    }

    .footer {
        margin-top: 15px;
        font-size: 13px;
        color: #ccc;
    }

    .footer a {
        color: #ff4d4d;
        text-decoration: none;
    }

    .footer a:hover {
        text-decoration: underline;
    }

</style>

</head>

<body>

<div class="container">
    <h2>ZOMATO</h2>

    <form action="signup">

        <div class="input-box">
            <label>Mobile</label>
            <input type="text" name="mobile" placeholder="Enter mobile number">
        </div>

        <div class="input-box">
            <label>Email</label>
            <input type="text" name="email" placeholder="Enter email">
        </div>

        <div class="input-box">
            <label>Location</label>
            <input type="text" name="location" placeholder="Enter your location">
        </div>

        <div class="input-box">
            <label>OTP</label>
            <input type="text" name="otp" placeholder="Enter OTP">
        </div>

        <input type="submit" value="Create Account" class="btn">

    </form>

    <div class="footer">
        Already have an account? <a href="showLogin">Login</a>
    </div>
</div>

</body>
</html>