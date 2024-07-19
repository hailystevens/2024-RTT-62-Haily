<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container">
    <!-- Customer Information -->
    <div class="row justify-content-center pt-5">
        <div class="col-8 text-center">
            <h2>${customer.customerName}</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <td>${customer.id}</td>
                </tr>
                <tr>
                    <th>Contact</th>
                    <td>${customer.contactFirstname}</td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td>${customer.phone}</td>
                </tr>
                <tr>
                    <th>Sales Rep</th>
                    <td><a href="/employees/employee/${customer.salesRepEmployeeId}">${customer.salesRepEmployeeId}</a></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- Customer's Orders -->
    <div class="row justify-content-center pt-5">
        <div class="col-8 text-center">
            <h2>${customer.customerName}'s Orders (${customer.orders.size()})</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Required Date</th>
                    <th>Order Comment</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customer.orders}" var="order">
                    <tr>
                        <td><a href="/orders/order/${order.id}">${order.id}</a></td>
                        <td>${order.orderDate}</td>
                        <td>${order.requiredDate}</td>
                        <td>${order.comment}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Back Button -->
    <div class="row justify-content-center pt-3">
        <div class="col-8 text-center">
            <button class="btn btn-secondary" onclick="window.location.assign('/customers/')">Back</button>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
