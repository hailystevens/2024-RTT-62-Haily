<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="../include/header.jsp"/>

<div class="container">
    <h1>Order List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Customer</th>
            <th>Order Date</th>
            <th>Status</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${ordersKey}">
            <tr>
                <td>${order.id}</td>
                <td>${order.customer.name}</td>
                <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd"/></td>
                <td>${order.status}</td>
                <td><a href="${pageContext.request.contextPath}/order/${order.id}">View Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../include/footer.jsp"/>
