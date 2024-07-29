<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Offices</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">${officesKey.size()} result(s)</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Office Code</th>
                        <th>City</th>
                        <th>Phone</th>
                        <th>Address Line 1</th>
                        <th>Address Line 2</th>
                        <th>State</th>
                        <th>Country</th>
                        <th>Postal Code</th>
                        <th>Territory</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${officesKey}" var="office">
                        <tr>
                            <td>${office.officeCode}</td>
                            <td>${office.city}</td>
                            <td>${office.phone}</td>
                            <td>${office.addressLine1}</td>
                            <td>${office.addressLine2}</td>
                            <td>${office.state}</td>
                            <td>${office.country}</td>
                            <td>${office.postalCode}</td>
                            <td>${office.territory}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
