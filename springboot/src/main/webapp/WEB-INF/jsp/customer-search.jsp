
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Find Customers</h1>
        </div>
    </div>
</section>

<!-- a search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center d-flex justify-content-center">
                <form action="/customer/search">
                    <div class="mb-3">
                        <div class="d-flex gap-1 justify-content-center">
                            <input style="width: 350px" type="text" value="${search}" class="form-control" id="search"
                                   name="search" placeholder="Enter customer name">
                            <button type="submit" class="btn btn-success">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-3">
            <div class="col-12">
                <h2 class="text-center">Customers Found (${customers.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-hover table-striped table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Customer Name</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Orders</th>
                    </tr>
                    <c:forEach items="${customers}" var="customer">
                        <tr onclick="window.location.href = '/customer/detail?customerId=${customer.id}'"
                            class="clickable-row">
                            <td>${customer.id}</td>
                            <td>${customer.customerName}</td>
                            <td>${customer.contactFirstname}</td>
                            <td>${customer.contactLastname}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.city}</td>
                            <td>${customer.country}</td>
                            <td><a href="/order/list?customerId=${customer.id}">See Orders</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

</section>

<jsp:include page="include/footer.jsp"/>
