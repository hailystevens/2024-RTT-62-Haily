<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<!-- page header -->
<%--<section style="background-color: rosybrown">--%>
<%--    <div class="container">--%>
<%--        <div class="row pt-5 pb-5">--%>

<h1 class="text-center">Employee Search Page</h1>

<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<!-- a search form -->

<section>

    <div class="container">

        <div class="row justify-content-center pt-5 pb-3">

            <div class="col-8 text-center">

                <form action="/employee/search">

                    <div class="mb-3">

                        <label for="search" class="form-label"><h4>Search Below</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search"
                               placeholder="Enter search term"/>


                    </div>
                    <button type="submit" class="btn btn-primary custom-primary custom-primary:hover">&#128269; Search
                    </button>

                </form>
            </div>
        </div>
    </div>
</section>


<section>

    <div class="container">
        <div class="row pt-5">
            <div class="col-12">

                <h2 class="text-center">Employees Found: (${employees.size()})</h2>

            </div>


        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <table class="table table-responsive">
                    <tr>
                        <th>Employee ID</th>
                        <th>Office ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Assigned Customers</th>


                    </tr>

                    <c:forEach items="${employees}" var="employee">

                        <tr onclick="window.location.href = '/employee/info?id=${employee.id}'" class="clickable-row">
                            <td>${employee.id}</td>
                            <td>${employee.officeId}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td onclick="window.location.href = '/customer/search?search=${employeeKey.id}'"
                                class="clickable-row" style="text-align: ">Customers
                            </td>


                        </tr>
                    </c:forEach>

                </table>
            </div>


        </div>

    </div>


</section>
<jsp:include page="../include/footer.jsp"/>
