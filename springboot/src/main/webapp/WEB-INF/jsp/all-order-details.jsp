
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Details</h1>
        </div>
    </div>
</section>

<div class="container d-flex flex-column align-items-center">
    <table class="table table-hover table-striped table-bordered">
        <tr>
            <th class="text-center">Order ID</th>
            <th class="text-center">Order Date</th>
            <th class="text-center">Product ID</th>
            <th>Product Name</th>
            <th class="text-end">Quantity</th>
            <th class="text-end">Price Each</th>
            <%--            <th class="text-end">Price Each</th>--%>
            <th class="text-end">Total</th>
        </tr>
        <h2 class="text-center mb-3">${orderDetails.size()} Products</h2>

        <c:forEach items="${orderDetails}" var="orderDetail">
            <tr>
                <td class="text-center">${orderDetail.order_id}</td>
                <td class="text-center">${orderDetail.order_date}</td>
                <td class="text-center">${orderDetail.product_id}</td>
                <td>${orderDetail.product_name}</td>
                <td class="text-end">${orderDetail.quantity_ordered}</td>
                <td class="text-end"><fmt:formatNumber type="currency" value="${orderDetail.price_each}"/></td>
                <td class="text-end"><fmt:formatNumber
                        type="currency">${orderDetail.line_item_total}</fmt:formatNumber></td>

            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="include/footer.jsp"/>
