<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Database Management System</title>
    <link rel="stylesheet" href="/pub/css/global.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body class="d-flex flex-column min-vh-100">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">capstone</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <!-- Admin Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="adminDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Admin
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="adminDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
                    </ul>
                </li>

                <!-- Customer Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="customerDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="customerDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/create">Create Customer</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/detail">Customer Detail</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/list">Customer List</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/list-by-employee">Customers by Employee</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/search">Search Customers</a></li>
                    </ul>
                </li>

                <!-- Order Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="orderDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Order
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="orderDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order/list">Order List</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order/detail">Order Detail</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order/list-by-customer">Orders by Customer</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order/search">Search Orders</a></li>
                    </ul>
                </li>

                <!-- Order Detail Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="orderDetailDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Order Detail
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="orderDetailDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order-detail/list">Order Detail List</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order-detail/detail">Order Detail</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/order-detail/list-by-order">Order Details by Order</a></li>
                    </ul>
                </li>

                <!-- Product Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="productDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Product
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="productDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/product/create">Create Product</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/product/detail">Product Detail</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/product/edit">Edit Product</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/product/list">Product List</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/product/search">Search Products</a></li>
                    </ul>
                </li>

                <!-- Auth Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="authDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        User
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="authDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/account/create-account">Create Account</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/account/login">Login</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="navbar-nav">
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/account/login">Log In</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/account/logout">Log Out</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>
