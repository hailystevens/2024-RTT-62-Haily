<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                <c:if test="${empty form.id}">
                    Create Customer
                </c:if>
                <c:if test="${not empty form.id}">
                    Edit Customer
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 justify-content-center">
            <div class="col-auto justify-content-center">
                <form class="card" style="width: 500px;" action="${pageContext.request.contextPath}/customer/createSubmit" method="post">
                    <div class="card-body">
                        <input type="hidden" name="id" value="${form.id}"/>
                        <div>
                            <label for="customerName" class="col-form-label">Customer Name</label>
                            <input type="text" id="customerName" name="customerName" value="${form.customerName}" class="form-control">
                        </div>
                        <div>
                            <label for="contactFirstname" class="col-form-label">Contact First Name</label>
                            <input type="text" id="contactFirstname" name="contactFirstname" value="${form.contactFirstname}" class="form-control">
                        </div>
                        <div>
                            <label for="contactLastname" class="col-form-label">Contact Last Name</label>
                            <input type="text" id="contactLastname" name="contactLastname" value="${form.contactLastname}" class="form-control">
                        </div>
                        <div>
                            <label for="phone" class="col-form-label">Phone</label>
                            <input type="text" id="phone" name="phone" value="${form.phone}" class="form-control">
                        </div>
                        <div>
                            <label for="addressLine1" class="col-form-label">Address Line 1</label>
                            <input type="text" id="addressLine1" name="addressLine1" value="${form.addressLine1}" class="form-control">
                        </div>
                        <div>
                            <label for="addressLine2" class="col-form-label">Address Line 2</label>
                            <input type="text" id="addressLine2" name="addressLine2" value="${form.addressLine2}" class="form-control">
                        </div>
                        <div>
                            <label for="city" class="col-form-label">City</label>
                            <input type="text" id="city" name="city" value="${form.city}" class="form-control">
                        </div>
                        <div>
                            <label for="state" class="col-form-label">State</label>
                            <input type="text" id="state" name="state" value="${form.state}" class="form-control">
                        </div>
                        <div>
                            <label for="postalCode" class="col-form-label">Postal Code</label>
                            <input type="text" id="postalCode" name="postalCode" value="${form.postalCode}" class="form-control">
                        </div>
                        <div>
                            <label for="country" class="col-form-label">Country</label>
                            <input type="text" id="country" name="country" value="${form.country}" class="form-control">
                        </div>
                        <div>
                            <label for="creditLimit" class="col-form-label">Credit Limit</label>
                            <input type="text" id="creditLimit" name="creditLimit" value="${form.creditLimit}" class="form-control">
                        </div>
                        <div>
                            <label for="salesRepEmployeeId" class="col-form-label">Sales Representative</label>
                            <select id="salesRepEmployeeId" name="salesRepEmployeeId" class="form-control">
                                <c:forEach items="${salesRepEmployees}" var="salesRepEmployee">
                                    <option value="${salesRepEmployee.id}" <c:if test="${salesRepEmployee.id == form.salesRepEmployeeId}">selected</c:if>>
                                            ${salesRepEmployee.firstname}, ${salesRepEmployee.lastname}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mt-5">
                            <button type="submit" class="btn btn-success w-100">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>
