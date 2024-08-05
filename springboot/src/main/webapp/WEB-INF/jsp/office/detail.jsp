<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/global.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Office Details</title>
</head>
<body>
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
                <table class="table table-bordered">
                    <tr>
                        <td><b>City</b></td>
                        <td>${officeKey.city}</td>
                    </tr>
                    <tr>
                        <td><b>Phone</b></td>
                        <td>${officeKey.phone}</td>
                    </tr>
                    <tr>
                        <td><b>Address Line 1</b></td>
                        <td>${officeKey.addressLine1}</td>
                    </tr>
                    <tr>
                        <td><b>Address Line 2</b></td>
                        <td>${officeKey.addressLine2}</td>
                    </tr>
                    <tr>
                        <td><b>State</b></td>
                        <td>${officeKey.state}</td>
                    </tr>
                    <tr>
                        <td><b>Country</b></td>
                        <td>${officeKey.country}</td>
                    </tr>
                    <tr>
                        <td><b>Postal Code</b></td>
                        <td>${officeKey.postalCode}</td>
                    </tr>
                    <tr>
                        <td><b>Territory</b></td>
                        <td>${officeKey.territory}</td>
                    </tr>
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
