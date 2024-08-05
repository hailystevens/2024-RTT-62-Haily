<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<!-- Page Header -->
<c:if test="${empty form.employeeId}">
    <h1 class="text-center">Create Employee</h1>
</c:if>
<c:if test="${not empty form.employeeId}">
    <h1 class="text-center">Edit Employee</h1>
</c:if>

<div>
    <c:if test="${not empty errorMessage}">
        <section>
            <div class="text-danger alert alert-danger text-center">
                    ${errorMessage}
            </div>
        </section>
    </c:if>

    <div class="container">
        <div class="pt-5">
            <form class="form-container" action="/employee/createSubmit" method="post">

                <input type="hidden" name="employeeId" value="${form.employeeId}">

                <!-- First Name Input -->
                <div class="row g-4 p-3 justify-content-center">
                    <div class="col-md-2">
                        <label class="visually-hidden" for="firstNameID">First Name</label>
                        <input type="text" id="firstNameID" name="firstName" placeholder="First Name"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("firstName")}'>is-invalid</c:if>"
                               value="${form.firstName}">
                        <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>

                    <!-- Last Name Input -->
                    <div class="col-md-2">
                        <label class="visually-hidden" for="lastNameID">Last Name</label>
                        <input type="text" id="lastNameID" name="lastName" placeholder="Last Name"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("lastName")}'>is-invalid</c:if>"
                               value="${form.lastName}">
                        <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>

                    <!-- Extension Input -->
                    <div class="col-md-1">
                        <label class="visually-hidden" for="extensionID">Extension</label>
                        <input type="text" id="extensionID" name="extension" placeholder="Ext"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("extension")}'>is-invalid</c:if>"
                               value="${form.extension}">
                        <c:if test="${bindingResult.hasFieldErrors('extension')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('extension')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </div>

                <!-- Email Input -->
                <div class="row g-4 p-3 justify-content-center">
                    <div class="col-5">
                        <label class="visually-hidden" for="emailID">Email</label>
                        <input type="text" id="emailID" name="email" placeholder="Email"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("email")}'>is-invalid</c:if>"
                               value="${form.email}">
                        <c:if test="${bindingResult.hasFieldErrors('email')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </div>

                <!-- Job Title Input -->
                <div class="row g-4 p-3 justify-content-center">
                    <div class="col-md-2">
                        <label class="visually-hidden" for="jobTitleID">Job Title</label>
                        <input type="text" id="jobTitleID" name="jobTitle" placeholder="Job Title"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("jobTitle")}'>is-invalid</c:if>"
                               value="${form.jobTitle}">
                        <c:if test="${bindingResult.hasFieldErrors('jobTitle')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('jobTitle')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>

                    <!-- Vacation Hours Input -->
                    <div class="col-md-1">
                        <label class="visually-hidden" for="vacationHoursID">Vacation Hours</label>
                        <input type="text" id="vacationHoursID" name="vacationHours" placeholder="Vacation Hours"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("vacationHours")}'>is-invalid</c:if>"
                               value="${form.vacationHours}">
                        <c:if test="${bindingResult.hasFieldErrors('vacationHours')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('vacationHours')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>

                    <!-- Profile Image URL Input -->
                    <div class="col-md-2">
                        <label class="visually-hidden" for="profileImageURLID">Profile Image</label>
                        <input type="text" id="profileImageURLID" name="profileImageURL" placeholder="Profile Image URL"
                               class="form-control <c:if test='${bindingResult.hasFieldErrors("profileImageURL")}'>is-invalid</c:if>"
                               value="${form.profileImageURL}">
                        <c:if test="${bindingResult.hasFieldErrors('profileImageURL')}">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('profileImageURL')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </div>

                <!-- Reports To and Office Selects -->
                <div class="row g-4 p-3 justify-content-center">
                    <div class="col-md-2">
                        <label for="reportsTo" class="visually-hidden">Reports To</label>
                        <select id="reportsTo" name="reportsTo" class="form-select">
                            <option disabled selected value="">Reports To&#129485;</option>
                            <c:forEach items="${reportsToEmployees}" var="employee">
                                <option value="${employee.id}" <c:if test="${employee.id eq form.reportsTo}">selected</c:if>>
                                        ${employee.firstName} ${employee.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-2">
                        <label for="officeId" class="visually-hidden">Reporting Office</label>
                        <select id="officeId" name="officeId" class="form-select">
                            <option disabled selected value="">Office &#127970;</option>
                            <c:forEach items="${reportingToOffice}" var="office">
                                <option value="${office.id}" <c:if test="${office.id eq form.officeId}">selected</c:if>>
                                        ${office.city}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- Submit Button -->
                <div class="row justify-content-center">
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary custom-primary custom-primary:hover">&#9998; Submit</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>
