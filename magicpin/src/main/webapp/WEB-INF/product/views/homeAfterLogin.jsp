<%@page import="com.magicpin.entity.UserEntity"%>
<%@ page isELIgnored="false"  %>
<%
UserEntity user = (UserEntity) session.getAttribute("loggedInUser");

if(user == null){
    response.sendRedirect("home.jsp");
    return;
}
%>

<h2>Welcome <%= user.getName() %></h2>

<hr/>

<% if("ADMIN".equalsIgnoreCase(user.getRole())) { %>

    <a href="addProductForm">Add Product</a><br/><br/>

    <a href="viewAll?status=ACTIVE">View Active Products</a><br/><br/>

    <a href="viewAll?status=INACTIVE">View Inactive Products</a><br/><br/>

<% } else { %>

    <a href="viewAll?status=ACTIVE">View Products</a><br/><br/>

<% } %>

<a href="logout">Logout</a>