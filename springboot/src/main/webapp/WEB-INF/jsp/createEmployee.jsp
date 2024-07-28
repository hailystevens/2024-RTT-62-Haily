<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                <c:if test="${empty form.id}">
                    Create Employee
                </c:if>
                <c:if test="${not empty form.id}">
                    Edit Employee
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 justify-content-center">
            <div class="col-auto justify-content-center">
                <form class="card" style="width: 500px;" action="${pageContext.request.contextPath}/employee/createSubmit" method="post" enctype="multipart/form-data">
                    <div class="card-body p-3">
                        <input type="hidden" name="id" value="${form.id}"/>
                        <div>
                            <label for="emailId" class="col-form-label">Email</label>
                            <input type="text" id="emailId" name="email"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                                   value="${form.email}">
                            <c:if test="${bindingResult.hasFieldErrors('email')}">
                                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="firstNameId" class="col-form-label">First Name</label>
                            <input type="text" id="firstNameId" name="firstname"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('firstname')}">is-invalid</c:if>"
                                   value="${form.firstname}">
                            <c:if test="${bindingResult.hasFieldErrors('firstname')}">
                                <c:forEach items="${bindingResult.getFieldErrors('firstname')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="lastNameId" class="col-form-label">Last Name</label>
                            <input type="text" id="lastNameId" name="lastname"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('lastname')}">is-invalid</c:if>"
                                   value="${form.lastname}">
                            <c:if test="${bindingResult.hasFieldErrors('lastname')}">
                                <c:forEach items="${bindingResult.getFieldErrors('lastname')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="jobTitleId" class="col-form-label">Job Title</label>
                            <input type="text" id="jobTitleId" name="jobTitle" value="${form.jobTitle}"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('jobTitle')}">is-invalid</c:if>">
                            <c:if test="${bindingResult.hasFieldErrors('jobTitle')}">
                                <c:forEach items="${bindingResult.getFieldErrors('jobTitle')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="officeId" class="col-form-label">Office</label>
                            <select id="officeId" name="officeId"
                                    class="form-control <c:if test="${bindingResult.hasFieldErrors('officeId')}">is-invalid</c:if>">
                                <option value="0">- Select Office -</option>
                                <c:forEach items="${offices}" var="office">
                                    <option value="${office.id}"
                                            <c:if test="${office.id == form.officeId}">selected</c:if>
                                    >${office.city}, ${office.country}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${bindingResult.hasFieldErrors('officeId')}">
                                <c:forEach items="${bindingResult.getFieldErrors('officeId')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="extensionId" class="col-form-label">Extension</label>
                            <input type="text" id="extensionId" name="extension" value="${form.extension}"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('extension')}">is-invalid</c:if>">
                            <c:if test="${bindingResult.hasFieldErrors('extension')}">
                                <c:forEach items="${bindingResult.getFieldErrors('extension')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="vacationHoursId" class="col-form-label">Vacation Hours</label>
                            <input type="number" id="vacationHoursId" name="vacationHours" value="${form.vacationHours}"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('vacationHours')}">is-invalid</c:if>">
                            <c:if test="${bindingResult.hasFieldErrors('vacationHours')}">
                                <c:forEach items="${bindingResult.getFieldErrors('vacationHours')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="reportsTo" class="col-form-label">Reports To</label>
                            <select id="reportsTo" name="reportsTo"
                                    class="form-control <c:if test="${bindingResult.hasFieldErrors('reportsTo')}">is-invalid</c:if>">
                                <option value="0">- Select Supervisor -</option>
                                <c:forEach items="${employees}" var="employee">
                                    <option value="${employee.id}" <c:if test="${employee.id == form.reportsTo}">selected</c:if>>
                                            ${employee.firstname} ${employee.lastname}
                                    </option>
                                </c:forEach>
                            </select>
                            <c:if test="${bindingResult.hasFieldErrors('reportsTo')}">
                                <c:forEach items="${bindingResult.getFieldErrors('reportsTo')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <c:if test="${form.id != null}">
                            <p>
                                <span class="fw-bold">Profile Image</span>
                                <span><img width="400" src="${form.profileImageUrl}"/></span>
                            </p>
                        </c:if>
                        <div>
                            <label for="profileImage" class="col-form-label">Upload New Profile Image</label>
                            <input type="file" id="profileImage" name="profileImage" class="form-control">
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
