<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<!-- a page header -->
<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Orders: ${customerName}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">${ordersKey.size()} result(s)</h4>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th><b>Order Id</b></th>
                        <th><b>Customer Id</b></th>
                        <th><b>Order Date</b></th>
                        <th><b>Shipped Date</b></th>
                        <th><b>Required Date</b></th>
                        <th><b>Status</b></th>
                        <th><b>Comments</b></th>
                        <th><b>Order Details</b></th>
                    </tr>

                    <c:forEach items="${ordersKey}" var="order">
                        <tr>
                            <td><a href="../order/${order.id}">${order.id}</a></td>
                            <td><a href="../customer/${order.customerId}">${order.customerId}</a></td>
                            <td>${order.orderDate}</td>
                            <td>${order.shippedDate}</td>
                            <td>${order.requiredDate}</td>
                            <td>${order.status}</td>
                            <td>${order.comments}</td>
                            <td><a href="../order/orderdetail?orderId=${order.id}">order details</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
