<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container">
    <!-- Order Information -->
    <div class="row text-center pt-5">
        <div class="col-12">
            <h2>Order - ${order.id}</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <tr>
                    <th>Order Date</th>
                    <td>${order.orderDate}</td>
                </tr>
                <tr>
                    <th>Shipped</th>
                    <td>${order.shippedDate}</td>
                </tr>
            </table>
        </div>
    </div>

    <!-- Order Details -->
    <div class="row text-center pt-5">
        <div class="col-12">
            <h2>Order Details</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Item ID</th>
                    <th>Amount Ordered</th>
                    <th>Price Per Item</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${order.orderDetails}" var="orderDetail">
                    <tr>
                        <td><a href="/item/${orderDetail.productID}">${orderDetail.productID}</a></td>
                        <td>${orderDetail.quantityOrdered}</td>
                        <td>${orderDetail.priceEach}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Back Button -->
    <div class="row justify-content-center pt-3">
        <div class="col-8 text-center">
            <button class="btn btn-secondary" onclick="window.location.assign('/orders/')">Back</button>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
