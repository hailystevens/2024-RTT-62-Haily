<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="../include/header.jsp" />

<div class="container">
    <h1>Customer Details</h1>
    <table>
        <tr>
            <th>Customer ID:</th>
            <td>${customerKey.id}</td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>${customerKey.name}</td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>${customerKey.email}</td>
        </tr>
        <tr>
            <th>Phone:</th>
            <td>${customerKey.phone}</td>
        </tr>
        <tr>
            <th>Billing Address:</th>
            <td>${customerKey.billingAddress}</td>
        </tr>
        <tr>
            <th>Shipping Address:</th>
            <td>${customerKey.shippingAddress}</td>
        </tr>
    </table>

    <h2>Orders</h2>
    <table>
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Status</th>
            <th>Payment Method</th>
            <th>Shipping Method</th>
            <th>Special Instructions</th>
            <th>Total Amount</th>
            <th>Tracking Number</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${ordersKey}">
            <tr>
                <td>${order.id}</td>
                <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td>${order.status}</td>
                <td>${order.paymentMethod}</td>
                <td>${order.shippingMethod}</td>
                <td>${order.specialInstructions}</td>
                <td><fmt:formatNumber value="${order.totalAmount}" type="currency" /></td>
                <td>${order.trackingNumber}</td>
                <td><a href="<c:url value='/order/${order.id}' />">View Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../include/footer.jsp" />
