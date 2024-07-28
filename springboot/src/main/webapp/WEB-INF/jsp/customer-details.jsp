<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Customer Details</h1>
        </div>
    </div>
</section>

<div class="container">
    <div class="mt-5">
        <p><span>ID: </span>${customer.id}</p>
        <p><span>Customer Name: </span>${customer.customerName}</p>
        <p><span>Contact First Name: </span>${customer.contactFirstname}</p>
        <p><span>Contact Last Name: </span>${customer.contactLastname}</p>
    </div>

    <h2 class="text-center">Orders Found (${orders.size()})</h2>
    <table class="table table-hover table-striped table-bordered">
        <tr>
            <th>Order ID</th>
            <th>Customer ID</th>
            <th>Status</th>
            <th>Ordered Date</th>
            <th>Comments</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr onclick="window.location.href = '/order/detail?orderId=${order.id}'" class="clickable-row">
                <td>${order.id}</td>
                <td>${order.customerId}</td>
                <td>${order.status}</td>
                <td>${order.orderDate}</td>
                <td>${order.comments}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="include/footer.jsp"/>
