<!DOCTYPE html>
<html>
<head>
    <title>Rapido Sign-up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #ffcc00, #ff9900);
            margin: 0;
            padding: 0;
        }

        .container {
            width: 350px;
            margin: 100px auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            text-align: center;
        }

        h2 {
            margin-bottom: 25px;
            color: #333;
        }

        input[type="text"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }

        input[type="text"]:focus {
            border-color: #ff9900;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #000;
            color: #fff;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }

        input[type="submit"]:hover {
            background: #333;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2>Rapido Sign-up</h2>

        <form action="signup">

            <input type="text" name="mobile" placeholder="Enter Mobile Number"><br>
            <input type="text" name="email" placeholder="Enter Email"><br>
            <input type="text" name="location" placeholder="Enter Location"><br>
            <input type="text" name="otp" placeholder="Enter OTP"><br>

            <input type="submit" value="Sign Up">
        </form>
    </div>

</body>
</html>