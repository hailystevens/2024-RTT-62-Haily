<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Orders</title>
</head>
<body>
<h2>Search Orders</h2>

<form:form action="/order/search" method="get">
    <div>
        <label for="search">Order Status:</label>
        <form:input path="search" id="search"/>
        <button type="submit">Search</button>
    </div>
</form:form>

<c:if test="${not empty ordersKey}">
    <h3>Search Results</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Required Date</th>
            <th>Shipped Date</th>
            <th>Status</th>
            <th>Comments</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${ordersKey}">
            <tr>
                <td><c:out value="${order.id}"/></td>
                <td><c:out value="${order.orderDate}"/></td>
                <td><c:out value="${order.requiredDate}"/></td>
                <td><c:out value="${order.shippedDate}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><c:out value="${order.comments}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty ordersKey}">
    <p>No orders found.</p>
</c:if>

</body>
</html>

<jsp:include page="../include/footer.jsp"/>
