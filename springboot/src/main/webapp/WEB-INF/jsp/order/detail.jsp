<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Details for Order ID: ${orderKey.id}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <tr><td><b>Order Date</b></td><td>${orderKey.orderDate}</td></tr>
                    <tr><td><b>Required Date</b></td><td>${orderKey.requiredDate}</td></tr>
                    <tr><td><b>Shipped Date</b></td><td>${orderKey.shippedDate}</td></tr>
                    <tr><td><b>Status</b></td><td>${orderKey.status}</td></tr>
                    <tr><td><b>Comments</b></td><td>${orderKey.comments}</td></tr>
                </table>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h4 class="text-center">Order Details</h4>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Product Code</th>
                        <th>Quantity Ordered</th>
                        <th>Price Each</th>
                        <th>Order Line Number</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderDetailsKey}" var="orderDetail">
                        <tr>
                            <td>${orderDetail.productCode}</td>
                            <td>${orderDetail.quantityOrdered}</td>
                            <td>${orderDetail.priceEach}</td>
                            <td>${orderDetail.orderLineNumber}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
