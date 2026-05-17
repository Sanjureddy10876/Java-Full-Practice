<!DOCTYPE html>
<html>
<head>
    <title>Zomato - Order Food</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
        }

        body {
            height: 100vh;
            background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)),
                        url('https://images.unsplash.com/photo-1504674900247-0877df9cc836');
            background-size: cover;
            background-position: center;
            color: white;
        }

        .navbar {
            display: flex;
            justify-content: flex-end;
            padding: 20px 60px;
        }

        .navbar a {
            text-decoration: none;
            color: white;
            margin-left: 25px;
            font-size: 18px;
            padding: 8px 16px;
            border-radius: 25px;
            transition: 0.3s;
        }

        .navbar a:hover {
            background: #ff4d4d;
        }

        .hero {
            display: flex;
            height: 80%;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .hero h1 {
            font-size: 60px;
            font-weight: bold;
            letter-spacing: 2px;
        }

        .hero p {
            font-size: 22px;
            margin: 15px 0 30px;
            color: #ddd;
        }

        .btn-container a {
            text-decoration: none;
            padding: 14px 30px;
            margin: 10px;
            font-size: 18px;
            border-radius: 30px;
            transition: 0.3s;
        }

        .signup {
            background: #ff4d4d;
            color: white;
        }

        .signup:hover {
            background: #e60023;
        }

        .login {
            border: 2px solid white;
            color: white;
        }

        .login:hover {
            background: white;
            color: black;
        }

        .footer {
            position: absolute;
            bottom: 10px;
            width: 100%;
            text-align: center;
            font-size: 14px;
            color: #ccc;
        }
    </style>
</head>

<body>

    <div class="navbar">
        <a href="showPage">Sign Up</a>
        <a href="showLogin">Login</a>
    </div>

    <div class="hero">
        <h1>ZOMATO</h1>
        <p>Discover the best food & drinks in your city</p>

        <div class="btn-container">
            <a href="showPage" class="signup">Get Started</a>
            <a href="showLogin" class="login">Login</a>
        </div>
    </div>

    <div class="footer">
        © 2026 Zomato Clone | Designed for WOW Experience 🚀
    </div>

</body>
</html>