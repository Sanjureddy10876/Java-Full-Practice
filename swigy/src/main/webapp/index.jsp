<!DOCTYPE html>
<html>
<head>
    <title>Swiggy Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #ff6a00, #ffb347);
            margin: 0;
            padding: 0;
        }

        .container {
            width: 400px;
            margin: 80px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #ff6a00;
            margin-bottom: 25px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 6px;
            border: 1px solid #ccc;
            outline: none;
            transition: 0.3s;
        }

        input[type="text"]:focus {
            border-color: #ff6a00;
            box-shadow: 0 0 5px rgba(255,106,0,0.5);
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #ff6a00;
            color: white;
            border: none;
            border-radius: 6px;
            margin-top: 20px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn:hover {
            background: #e65c00;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>🍔 Swiggy Application</h2>

    <form action="foods" method="post">
        
        <label>Food Name</label>
        <input type="text" name="foodName" placeholder="Enter food name">

        <label>Food ID</label>
        <input type="text" name="foodId" placeholder="Enter food ID">

        <label>Quantity</label>
        <input type="text" name="qty" placeholder="Enter quantity">

        <label>Food Type</label>
        <input type="text" name="type" placeholder="Veg / Non-Veg">

        <input type="submit" class="btn" value="Add Food Item">
    </form>
</div>

</body>
</html>