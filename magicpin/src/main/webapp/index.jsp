

<!DOCTYPE html>
<html>
<head>
    <title>E-Commerce Home</title>

    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial;
        }

        /* Full screen background image */
        .hero {
            background-image: url('https://via.placeholder.com/1500x800?text=E-Commerce+Store');
            height: 100%;
            background-position: center;
            background-size: cover;
            position: relative;
        }

        /* Navbar */
        .navbar {
            position: absolute;
            top: 0;
            right: 0;
            padding: 20px;
        }

        .navbar a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
            font-weight: bold;
            background-color: rgba(0,0,0,0.5);
            padding: 8px 12px;
            border-radius: 5px;
        }

        .navbar a:hover {
            background-color: black;
        }

        /* Center text */
        .center-text {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
            text-align: center;
        }

        .center-text h1 {
            font-size: 40px;
        }
    </style>

</head>
<body>

<div class="hero">

    <!-- 🔝 Top Right Links -->
    <div class="navbar">
        <a href="UserReg">Register</a>
        <a href="loginForm?role=USER">User Login</a>
        <a href="loginForm?role=ADMIN">Admin Login</a>
    </div>

    <!-- 🏷 Center Content -->
    <div class="center-text">
        <h1>Welcome to E-Commerce Store</h1>
        <p>Shop the best products at best prices</p>
    </div>

</div>

</body>
</html>
