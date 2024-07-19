<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<script>
    let showTable = false;
    function handleClick() {
        let table = document.getElementsByTagName("table")[0];
        if (!showTable && table) {
            table.remove();
        }
    }
</script>

<div class="container">
    <section>
        <div class="row">
            <div class="col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col-8">
                <form action="/employees/search" method="get">
                    <div class="mb-3">
                        <label for="name" class="form-label"><h4>Employee Search</h4></label>
                        <input name="name" id="name" type="text" class="form-control" value="${name}" placeholder="Enter name here" aria-describedby="nameHelp">
                        <small id="nameHelp" class="form-text text-muted">Enter the employee name to search for.</small>
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>

    <section>
        <div class="row justify-content-center">
            <div class="col-8">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Office Number</th>
                        <th>Name</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td><a href="/employees/employeeItem?name=${employee.id}">${employee.id}</a></td>
                            <td>${employee.officeId}</td>
                            <td>${employee.firstname}, ${employee.lastname}</td>
                            <td>${employee.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>

<jsp:include page="include/footer.jsp" />
