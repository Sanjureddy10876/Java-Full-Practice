<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<h2>Orders</h2>



<table border="1">
<tr>
    <th>Name</th>
    <th>Ordered By</th>
    <th>Description</th>
</tr>

<c:forEach var="order" items="${response}">
<tr>
    <td>${order.name}</td>
    <td>${order.orderedBy}</td>
    <td>${order.orderDescription}</td>
</tr>
</c:forEach>

</table>