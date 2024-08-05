<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/global.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Offices</title>
</head>
<body>
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
                <table class="table table-striped table-bordered">
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

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMN2lVdx6+r2OQJeyz/dW8eMoe9bPvG5rV1sor0Nxgl22WFnyFqzcbfZop7qCzM9" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cv0qX3ggo7K4Ciz21HhBjFp2teFDfWrpg0YfP2FZjPzvF2la9MtvbDkXZP2WJ8n8" crossorigin="anonymous"></script>
</body>
</html>
