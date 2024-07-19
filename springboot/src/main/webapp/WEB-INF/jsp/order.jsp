<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container">
    <section>
        <div class="row">
            <div class="col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col-8">
                <form action="/orders/search" method="get">
                    <div class="mb-3">
                        <label for="name" class="form-label"><h4>Order Search</h4></label>
                        <input name="name" id="name" type="text" class="form-control" value="${name}" placeholder="Enter name here" aria-describedby="nameHelp">
                        <small id="nameHelp" class="form-text text-muted">Enter the customer name to search for orders.</small>
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>
    <section>
        <div class="row justify-content-center">
            <div class="col-8">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Customer ID</th>
                        <th>Order Date</th>
                        <th>Shipped Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td><a href="/orders/order/${order.id}">${order.id}</a></td>
                            <td>${order.customerId}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.shippedDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>

<jsp:include page="include/footer.jsp" />
