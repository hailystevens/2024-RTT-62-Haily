<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Office</title>

    <!-- Link to CSS file -->
    <link href="/css/global.css" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
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

                    <!-- City input -->
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="cityId" class="col-form-label">City</label>
                        </div>
                        <div class="col-4">
                            <form:input path="city" id="cityId" class="form-control"/>
                        </div>
                    </div>

                    <!-- Phone input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="phoneId" class="col-form-label">Phone</label>
                        </div>
                        <div class="col-4">
                            <form:input path="phone" id="phoneId" class="form-control"/>
                        </div>
                    </div>

                    <!-- Address Line 1 input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="addressLine1Id" class="col-form-label">Address Line 1</label>
                        </div>
                        <div class="col-4">
                            <form:input path="addressLine1" id="addressLine1Id" class="form-control"/>
                        </div>
                    </div>

                    <!-- Address Line 2 input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="addressLine2Id" class="col-form-label">Address Line 2</label>
                        </div>
                        <div class="col-4">
                            <form:input path="addressLine2" id="addressLine2Id" class="form-control"/>
                        </div>
                    </div>

                    <!-- State input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="stateId" class="col-form-label">State</label>
                        </div>
                        <div class="col-4">
                            <form:input path="state" id="stateId" class="form-control"/>
                        </div>
                    </div>

                    <!-- Country input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="countryId" class="col-form-label">Country</label>
                        </div>
                        <div class="col-4">
                            <form:input path="country" id="countryId" class="form-control"/>
                        </div>
                    </div>

                    <!-- Postal Code input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="postalCodeId" class="col-form-label">Postal Code</label>
                        </div>
                        <div class="col-4">
                            <form:input path="postalCode" id="postalCodeId" class="form-control"/>
                        </div>
                    </div>

                    <!-- Territory input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="territoryId" class="col-form-label">Territory</label>
                        </div>
                        <div class="col-4">
                            <form:input path="territory" id="territoryId" class="form-control"/>
                        </div>
                    </div>

                    <!-- Submit Button -->
                    <div class="row justify-content-center pt-3">
                        <div class="col-auto text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMN2lVdx6+r2OQJeyz/dW8eMoe9bPvG5rV1sor0Nxgl22WFnyFqzcbfZop7qCzM9" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cv0qX3ggo7K4Ciz21HhBjFp2teFDfWrpg0YfP2FZjPzvF2la9MtvbDkXZP2WJ8n8" crossorigin="anonymous"></script>
</body>
</html>
