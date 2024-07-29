<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employees</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <c:if test="${param.success == 'true'}">
                    <div class="alert alert-success text-center">Employee saved successfully!</div>
                </c:if>
                <h4 class="text-center">${employeesKey.size()} result(s)</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Office Code</th>
                        <th>Job Title</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeesKey}" var="employee">
                        <tr>
                            <td>${employee.id}</td>
                            <td><a href="/employee/${employee.id}">${employee.firstName}</a></td>
                            <td>${employee.lastName}</td>
                            <td>${employee.email}</td>
                            <td>${employee.officeCode}</td>
                            <td>${employee.jobTitle}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
