
<!DOCTYPE html>
<%@ page isELIgnored="false"  %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login Form</h2>

<form action="login" method="post">

    <!-- Hidden role -->
    <input type="hidden" name="role" value="${role}"/>

    User Name: <input type="text" name="userName" required/> <br/><br/>
    Password: <input type="password" name="password" required/> <br/><br/>

    <button type="submit">Login</button>

</form>

<h3 style="color:red;">${message}</h3>

</body>
</html>

