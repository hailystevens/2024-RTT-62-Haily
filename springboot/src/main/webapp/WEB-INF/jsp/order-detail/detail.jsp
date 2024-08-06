<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Detail: ${orderDetailKey.id}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="table">
            <div class="row">
                <div class="col-8">
                    <table class="table">
                        <tr>
                            <td><b>Order Detail Id</b></td>
                            <td>${orderDetailKey.id}</td>
                        </tr>
                        <tr>
                            <td><b>Order Id</b></td>
                            <td><a href="../order/${orderDetailKey.orderId}">${orderDetailKey.orderId}</a></td>
                        </tr>
                        <tr>
                            <td><b>Product Id</b></td>
                            <td><a href="../product/${orderDetailKey.productId}">${orderDetailKey.productId}</a></td>
                        </tr>
                        <tr>
                            <td><b>Quantity Ordered</b></td>
                            <td>${orderDetailKey.quantityOrdered}</td>
                        </tr>
                        <tr>
                            <td><b>Price Each</b></td>
                            <td>${orderDetailKey.priceEach}</td>
                        </tr>
                        <tr>
                            <td><b>Order Line Number</b></td>
                            <td>${orderDetailKey.orderLineNumber}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
