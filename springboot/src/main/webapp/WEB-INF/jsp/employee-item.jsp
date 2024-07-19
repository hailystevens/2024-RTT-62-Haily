<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container">
    <!-- Employee Information -->
    <div class="row justify-content-center pt-5">
        <div class="col-8 text-center">
            <h2>${employee.firstname}, ${employee.lastname}</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <td>${employee.id}</td>
                </tr>
                <tr>
                    <th>Office</th>
                    <td>${employee.officeId}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <th>Extension</th>
                    <td>${employee.extension}</td>
                </tr>
            </table>
        </div>
    </div>

    <!-- Employee's Customers -->
    <div class="row justify-content-center pt-5">
        <div class="col-8 text-center">
            <h2>${employee.firstname}'s Customers (${employee.customers.size()})</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employee.customers}" var="customer">
                    <tr>
                        <td><a href="/customers/customer/${customer.id}">${customer.id}</a></td>
                        <td>${customer.customerName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Back Button -->
    <div class="row justify-content-center pt-3">
        <div class="col-8 text-center">
            <button class="btn btn-secondary" onclick="window.location.assign('/employees/')">Back</button>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
