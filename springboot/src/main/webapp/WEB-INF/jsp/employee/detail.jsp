<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Employee: ${employeeKey.firstName} ${employeeKey.lastName}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <tr><td><b>Employee Id</b></td><td>${employeeKey.id}</td></tr>
                    <tr><td><b>First Name</b></td><td>${employeeKey.firstName}</td></tr>
                    <tr><td><b>Last Name</b></td><td>${employeeKey.lastName}</td></tr>
                    <tr><td><b>Email</b></td><td>${employeeKey.email}</td></tr>
                    <tr><td><b>Office Code</b></td><td>${employeeKey.officeCode}</td></tr>
                    <tr><td><b>Job Title</b></td><td>${employeeKey.jobTitle}</td></tr>
                </table>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <a href="/employee/list">View all employees</a>
                <br>
                <a href="/employee/search">Search for employees</a>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
