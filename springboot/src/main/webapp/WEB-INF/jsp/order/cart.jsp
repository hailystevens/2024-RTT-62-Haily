<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">My Cart</h1>
        </div>

        <c:if test="${not empty orderDetails}">
            <table class="table">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price Each</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderDetail" items="${orderDetails}">
                    <tr>
                        <td>${orderDetail.product.name}</td>
                        <td>${orderDetail.quantityOrdered}</td>
                        <td><fmt:formatNumber value="${orderDetail.priceEach}" type="currency" currencySymbol="$"/></td>
                        <td><fmt:formatNumber value="${orderDetail.priceEach * orderDetail.quantityOrdered}" type="currency" currencySymbol="$"/></td>
                        <td>
                            <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/order/removeFromCart?orderDetailId=${orderDetail.id}"
                               onclick="return confirm('Are you sure you want to remove this item?')">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="text-end">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/order/checkout">Checkout</a>
            </div>
        </c:if>
        <c:if test="${empty orderDetails}">
            <p class="text-center">Your cart is empty.</p>
        </c:if>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
