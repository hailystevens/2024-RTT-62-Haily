<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Search</title>
    <link rel="stylesheet" href="/pub/css/global.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../include/header.jsp"/>

<section class="pt-5">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order Search Page</h1>
        </div>
    </div>
</section>

<!-- Search Form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/orders/search">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Search Below</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search" placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary custom-primary custom-primary:hover">&#128269; Search</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Search Results -->
<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Orders Found: (${orders.size()})</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <table class="table table-striped table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Customer ID</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr onclick="window.location.href = '/order/info?id=${order.id}'" class="clickable-row">
                            <td>${order.id}</td>
                            <td>${order.customerID}</td>
                            <td>${order.status}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMN2lVdx6+r2OQJeyz/dW8eMoe9bPvG5rV1sor0Nxgl22WFnyFqzcbfZop7qCzM9" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cv0qX3ggo7K4Ciz21HhBjFp2teFDfWrpg0YfP2FZjPzvF2la9MtvbDkXZP2WJ8n8" crossorigin="anonymous"></script>
</body>
</html>
