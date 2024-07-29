<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Office Details for Office Code: ${officeKey.officeCode}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table">
                    <tr><td><b>City</b></td><td>${officeKey.city}</td></tr>
                    <tr><td><b>Phone</b></td><td>${officeKey.phone}</td></tr>
                    <tr><td><b>Address Line 1</b></td><td>${officeKey.addressLine1}</td></tr>
                    <tr><td><b>Address Line 2</b></td><td>${officeKey.addressLine2}</td></tr>
                    <tr><td><b>State</b></td><td>${officeKey.state}</td></tr>
                    <tr><td><b>Country</b></td><td>${officeKey.country}</td></tr>
                    <tr><td><b>Postal Code</b></td><td>${officeKey.postalCode}</td></tr>
                    <tr><td><b>Territory</b></td><td>${officeKey.territory}</td></tr>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
