<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Customer: ${customerKey.customerName}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <tr><td><b>Customer Id</b></td><td>${customerKey.id}</td></tr>
                    <tr><td><b>Name</b></td><td>${customerKey.customerName}</td></tr>
                    <tr><td><b>Contact First Name</b></td><td>${customerKey.contactFirstName}</td></tr>
                    <tr><td><b>Contact Last Name</b></td><td>${customerKey.contactLastName}</td></tr>
                    <tr><td><b>Phone</b></td><td>${customerKey.phone}</td></tr>
                    <tr><td><b>Sales Rep Employee ID</b></td><td><a href="/employee/${customerKey.salesRepEmployeeId}">${customerKey.salesRepEmployeeId}</a></td></tr>
                    <tr><td><b>Orders:</b></td><td>${ordersKey.size()} result(s)</td></tr>
                </table>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Order Date</th>
                        <th>Shipped Date</th>
                        <th>Date Required</th>
                        <th>Status</th>
                        <th>Comments</th>
                        <th>Order Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ordersKey}" var="order">
                        <tr>
                            <td><a href="/order/${order.id}">${order.id}</a></td>
                            <td>${order.orderDate}</td>
                            <td>${order.shippedDate}</td>
                            <td>${order.requiredDate}</td>
                            <td>${order.status}</td>
                            <td>${order.comments}</td>
                            <td><a href="/order-detail/list-by-order?id=${order.id}">order details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <a href="/customer/list">View all customers</a>
                <br>
                <a href="/customer/search">Search for customers</a>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
