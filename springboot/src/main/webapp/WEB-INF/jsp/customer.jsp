<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container">
    <!-- Search Form -->
    <section>
        <div class="row">
            <div class="col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col-8">
                <form action="/customers/search" method="get">
                    <div class="mb-3">
                        <label for="name" class="form-label"><h4>Customer Search</h4></label>
                        <input name="name" id="name" type="text" class="form-control" value="${name}" placeholder="Enter name here" aria-describedby="nameHelp">
                        <small id="nameHelp" class="form-text text-muted">Enter the customer name to search for.</small>
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>

    <!-- Customer List -->
    <section>
        <div class="row justify-content-center pt-3">
            <div class="col-8">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer Name</th>
                        <th>Country</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td><a href="/customers/customer/${customer.id}">${customer.id}</a></td>
                            <td>${customer.customerName}</td>
                            <td>${customer.country}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>

<jsp:include page="include/footer.jsp" />
