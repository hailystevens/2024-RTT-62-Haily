<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section>
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
        <div class="row pt-5">
            <div class="col-12">
                <form action="/customer/createSubmit" method="post">
                    <input type="hidden" name="id" value="${form.id}">

                    <div class="row align-items-center pb-3">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-2">
                                <label for="customerNameId" class="col-form-label">Customer Name</label>
                            </div>
                            <div class="col-4">
                                <input type="text"
                                       id="customerNameId"
                                       name="customerName"
                                       class="form-control <c:if test="${bindingResult.hasFieldErrors('customerName')}">is-invalid</c:if>"
                                       value="${form.customerName}">
                            </div>
                        </div>

                        <c:if test="${bindingResult.hasFieldErrors('customerName')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('customerName')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Repeat the above structure for other fields like contactFirstName, contactLastName, etc. -->

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="salesRepEmployeeIdId" class="col-form-label">Sales Representative</label>
                            </div>
                            <div class="col-4">
                                <select id="salesRepEmployeeIdId" name="salesRepEmployeeId" class="form-control">
                                    <c:forEach items="${employeesKey}" var="employee">
                                        <option value="${employee.id}" <c:if test="${employee.id == form.salesRepEmployeeId}">selected</c:if>>
                                                ${employee.firstName} ${employee.lastName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="row justify-content-center pt-3">
                            <div class="col-auto text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
