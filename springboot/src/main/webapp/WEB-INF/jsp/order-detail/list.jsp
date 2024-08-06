<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Details</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">${orderDetailsKey.size()} result(s)</h4>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th><b>Order Detail Id</b></th>
                        <th><b>Order Id</b></th>
                        <th><b>Product Id</b></th>
                        <th><b>Quantity Ordered</b></th>
                        <th><b>Price Each</b></th>
                        <th><b>Order Line Number</b></th>
                    </tr>

                    <c:forEach items="${orderDetailsKey}" var="orderDetail">
                        <tr>
                            <td><a href="../order-detail/${orderDetail.id}">${orderDetail.id}</a></td>
                            <td><a href="../order/${orderDetail.orderId}">${orderDetail.orderId}</a></td>
                            <td><a href="../product/${orderDetail.productId}">${orderDetail.productId}</a></td>
                            <td>${orderDetail.quantityOrdered}</td>
                            <td>${orderDetail.priceEach}</td>
                            <td>${orderDetail.orderLineNumber}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
