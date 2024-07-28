<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee Details</h1>
        </div>
    </div>
</section>

<div class="container d-flex flex-column align-items-center">
    <div class="mt-2 d-inline px-5 p-4 pb-2 border mb-4 border-1 rounded-2">
        <h2 class="text-center fs-1 mb-4">${employee.firstname} ${employee.lastname}</h2>
        <p class="fs-5"><span class="fw-bold">ID: </span>${employee.id}</p>
        <p class="fs-5"><span class="fw-bold">Email: </span>${employee.email}</p>
        <p class="fs-5"><span class="fw-bold">Job Title: </span>${employee.jobTitle}</p>
        <p class="fs-5"><span class="fw-bold">Office: </span>${employeeOffice.addressLine1}, ${employeeOffice.city}, ${employeeOffice.country}</p>
        <p class="fs-5"><span class="fw-bold">Extension: </span>${employee.extension}</p>
        <p class="fs-5"><span class="fw-bold">Vacation: </span>${employee.vacationHours} hours</p>
        <p class="fs-5">
            <span class="fw-bold">Profile Image</span>
            <span><img width="400" src="${employee.profileImageUrl}"/></span>
        </p>
        <a href="${pageContext.request.contextPath}/employee/edit?employeeId=${employee.id}">Edit</a>
        <a href="${pageContext.request.contextPath}/file-upload?employeeId=${employee.id}">Upload Profile Image</a>
    </div>

    <table class="table table-hover table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Customer Name</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Orders</th>
        </tr>
        <h2 class="text-center mb-3">Customers Found (${customers.size()})</h2>

        <c:forEach items="${customers}" var="customer">
            <tr onclick="window.location.href = '${pageContext.request.contextPath}/customer/detail?customerId=${customer.id}'" class="clickable-row">
                <td>${customer.id}</td>
                <td>${customer.customerName}</td>
                <td>${customer.contactFirstname}</td>
                <td>${customer.contactLastname}</td>
                <td><a href="${pageContext.request.contextPath}/order/list?customerId=${customer.id}">See Orders</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="include/footer.jsp"/>
