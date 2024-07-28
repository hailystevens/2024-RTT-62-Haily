<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Find Employees</h1>
        </div>
    </div>
</section>

<!-- a search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center d-flex justify-content-center">
                <form action="${pageContext.request.contextPath}/employee/search" method="get">
                    <div class="mb-3">
                        <div class="d-flex gap-1 justify-content-center">
                            <input style="width: 350px" type="text" value="${search}" class="form-control" id="search"
                                   name="search" placeholder="Enter employee name">
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
                <h2 class="text-center">Employees Found (${employees.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-hover table-striped table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Job Title</th>
                        <th>Customers</th>
                    </tr>
                    <c:forEach items="${employees}" var="employee">
                        <tr onclick="window.location.href = '${pageContext.request.contextPath}/employee/detail?employeeId=${employee.id}'"
                            class="clickable-row">
                            <td>${employee.id}</td>
                            <td>${employee.firstname}</td>
                            <td>${employee.lastname}</td>
                            <td>${employee.email}</td>
                            <td>${employee.jobTitle}</td>
                            <td><a href="${pageContext.request.contextPath}/employee/detail?employeeId=${employee.id}">See Customers</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>
