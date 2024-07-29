<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <h1>${form.id == null ? "Create Employee" : "Edit Employee"}</h1>
        <form action="${pageContext.request.contextPath}/employee/createSubmit" method="post">
            <input type="hidden" name="id" value="${form.id}" />

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${form.firstName}" required />
                <c:if test="${bindingResult.fieldErrorCount('firstName') > 0}">
                    <div class="alert alert-danger">${bindingResult.getFieldError('firstName').defaultMessage}</div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${form.lastName}" required />
                <c:if test="${bindingResult.fieldErrorCount('lastName') > 0}">
                    <div class="alert alert-danger">${bindingResult.getFieldError('lastName').defaultMessage}</div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${form.email}" required />
                <c:if test="${bindingResult.fieldErrorCount('email') > 0}">
                    <div class="alert alert-danger">${bindingResult.getFieldError('email').defaultMessage}</div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="jobTitle">Job Title:</label>
                <input type="text" id="jobTitle" name="jobTitle" value="${form.jobTitle}" />
            </div>

            <div class="form-group">
                <label for="extension">Extension:</label>
                <input type="text" id="extension" name="extension" value="${form.extension}" />
            </div>

            <div class="form-group">
                <label for="reportsTo">Reports To:</label>
                <select id="reportsTo" name="reportsTo">
                    <option value="">-- Select Employee --</option>
                    <c:forEach var="employee" items="${employeesKey}">
                        <option value="${employee.id}" <c:if test="${employee.id == form.reportsTo}">selected</c:if>>${employee.firstName} ${employee.lastName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="vacationHours">Vacation Hours:</label>
                <input type="number" id="vacationHours" name="vacationHours" value="${form.vacationHours}" />
            </div>

            <div class="form-group">
                <label for="profileImageUrl">Profile Image URL:</label>
                <input type="text" id="profileImageUrl" name="profileImageUrl" value="${form.profileImageUrl}" />
            </div>

            <div class="form-group">
                <label for="officeId">Office ID:</label>
                <input type="number" id="officeId" name="officeId" value="${form.officeId}" />
            </div>

            <button type="submit" class="btn btn-primary">${form.id == null ? "Create" : "Update"}</button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
