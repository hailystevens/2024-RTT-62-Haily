<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="../include/header.jsp"/>

<div class="container">
    <h1>Order Details</h1>

    <c:if test="${not empty orderKey}">
        <h3>Order ID: ${orderKey.id}</h3>
        <p><strong>Customer:</strong> ${orderKey.customer.name}</p>
        <p><strong>Order Date:</strong> <fmt:formatDate value="${orderKey.orderDate}" pattern="yyyy-MM-dd"/></p>
        <p><strong>Status:</strong> ${orderKey.status}</p>
        <p><strong>Payment Method:</strong> ${paymentMethod}</p>
        <p><strong>Shipping Method:</strong> ${shippingMethod}</p>
        <p><strong>Special Instructions:</strong> ${specialInstructions}</p>
        <p><strong>Total Amount:</strong> <fmt:formatNumber value="${totalAmount}" type="currency"/></p>
        <p><strong>Tracking Number:</strong> ${trackingNumber}</p>

        <h4>Order Items</h4>
        <table class="table">
            <thead>
            <tr>
                <th>Product Name</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="detail" items="${orderDetailsKey}">
                <tr>
                    <td>${detail.product.name}</td>
                    <td>${detail.quantityOrdered}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty orderKey}">
        <p>Order not found.</p>
    </c:if>
</div>
<jsp:include page="../include/footer.jsp"/>
