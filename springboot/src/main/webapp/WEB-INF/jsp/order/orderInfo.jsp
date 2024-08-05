<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Info</title>
    <link rel="stylesheet" href="/pub/css/global.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../include/header.jsp"/>

<h1 class="text-center mt-5">Order Info</h1>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-auto">
            <table class="table table-striped table-bordered">
                <tr>
                    <td style="font-weight: bolder;">Order ID:</td>
                    <td>${orderKey.id}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Customer ID:</td>
                    <td>${orderKey.customerID}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Order Date:</td>
                    <td>${orderKey.orderDate}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Required Date:</td>
                    <td>${orderKey.requiredDate}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Shipped Date:</td>
                    <td>${orderKey.shippedDate}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Status:</td>
                    <td>${orderKey.status}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Comments:</td>
                    <td>${orderKey.comments}</td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div class="container mt-5">
    <p>
        <a class="btn btn-primary custom-primary custom-primary:hover" data-bs-toggle="collapse" href="#collapseExample"
           role="button" aria-expanded="false" aria-controls="collapseExample">
            Order Details
        </a>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <div class="row pt-5">
                <div class="col-12">
                    <h2 class="text-center">Order Total:</h2>
                </div>
            </div>
            <div class="row pt-3 justify-content-center">
                <div class="col-8">
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Order ID:</th>
                            <th>Product ID:</th>
                            <th>Product Name:</th>
                            <th>Quantity Ordered:</th>
                            <th>Price Each:</th>
                            <th>Line Item Total:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orderDetails}" var="order">
                            <tr onclick="window.location.href = '/product/info?id=${order.product_id}'" class="clickable-row">
                                <td>${order.order_id}</td>
                                <td>${order.product_id}</td>
                                <td>${order.product_name}</td>
                                <td>${order.quantity_ordered}</td>
                                <td>${order.price_each}</td>
                                <td>${order.line_item_total}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMN2lVdx6+r2OQJeyz/dW8eMoe9bPvG5rV1sor0Nxgl22WFnyFqzcbfZop7qCzM9" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cv0qX3ggo7K4Ciz21HhBjFp2teFDfWrpg0YfP2FZjPzvF2la9MtvbDkXZP2WJ8n8" crossorigin="anonymous"></script>
</body>
</html>
