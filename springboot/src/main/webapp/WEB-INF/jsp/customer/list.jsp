<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Customers</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">${customersKey.size()} result(s)</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Customer Name</th>
                        <th>Contact First Name</th>
                        <th>Contact Last Name</th>
                        <th>Phone</th>
                        <th>Orders</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${customersKey}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td><a href="/customer/${customer.id}">${customer.customerName}</a></td>
                            <td>${customer.contactFirstName}</td>
                            <td>${customer.contactLastName}</td>
                            <td>${customer.phone}</td>
                            <td><a href="/order/list-by-customer?id=${customer.id}&name=${customer.customerName}">orders</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
