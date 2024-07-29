<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                <c:if test="${empty form.officeCode}">
                    Create Office
                </c:if>
                <c:if test="${not empty form.officeCode}">
                    Edit Office
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form:form action="/office/createSubmit" method="post">
                    <input type="hidden" name="officeCode" value="${form.officeCode}">

                    <div class="row align-items-center pb-3">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-2">
                                <label for="cityId" class="col-form-label">City</label>
                            </div>
                            <div class="col-4">
                                <form:input path="city" id="cityId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="phoneId" class="col-form-label">Phone</label>
                            </div>
                            <div class="col-4">
                                <form:input path="phone" id="phoneId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="addressLine1Id" class="col-form-label">Address Line 1</label>
                            </div>
                            <div class="col-4">
                                <form:input path="addressLine1" id="addressLine1Id" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="addressLine2Id" class="col-form-label">Address Line 2</label>
                            </div>
                            <div class="col-4">
                                <form:input path="addressLine2" id="addressLine2Id" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="stateId" class="col-form-label">State</label>
                            </div>
                            <div class="col-4">
                                <form:input path="state" id="stateId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="countryId" class="col-form-label">Country</label>
                            </div>
                            <div class="col-4">
                                <form:input path="country" id="countryId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="postalCodeId" class="col-form-label">Postal Code</label>
                            </div>
                            <div class="col-4">
                                <form:input path="postalCode" id="postalCodeId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="territoryId" class="col-form-label">Territory</label>
                            </div>
                            <div class="col-4">
                                <form:input path="territory" id="territoryId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row justify-content-center pt-3">
                            <div class="col-auto text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
