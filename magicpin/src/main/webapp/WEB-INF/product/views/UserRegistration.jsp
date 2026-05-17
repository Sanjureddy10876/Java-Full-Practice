
<!DOCTYPE html>
<%@ page isELIgnored="false"  %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h2>Registration Form</h2>

<form action="register" method="post">

    User Name: <input type="text" name="name" required/> <br/><br/>
    
    Email: <input type="email" name="email" required/> <br/><br/>
    
    Phone: <input type="text" name="phone" required/> <br/><br/>
    
    Password: <input type="password" name="password" required/> <br/><br/>

    <!-- ✅ Role Dropdown -->
    Role:
    <select name="role">
        <option value="USER">User</option>
        <option value="ADMIN">Admin</option>
    </select>
    <br/><br/>

    <button type="submit">Register</button>

</form>

<h3 style="color:green;">${message}</h3>

<c:if test="${message == 'Registration Successful'}">
    <br/>
    <a href="loginForm?role=USER">User Login</a><br/><br/>
    <a href="loginForm?role=ADMIN">Admin Login</a>
</c:if>

</body>
</html>

