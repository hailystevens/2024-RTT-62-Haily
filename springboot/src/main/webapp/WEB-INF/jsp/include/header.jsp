<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/global.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Application</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="#" style="width: 100px" alt="Brand Logo"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/product/search">Products</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="${pageContext.request.contextPath}/orders/search">Orders</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="${pageContext.request.contextPath}/fileUpload">Upload File</a>--%>
<%--                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/account/create-account">Register</a>
                </li>
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
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="employeeDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Employee Actions
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="employeeDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/employee/search">Employee Search</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/employee/create">Employee Create</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/employee/edit?employeeId=">Employee Edit</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="customerDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Customer Actions
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="customerDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/search">Customer Search</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/create">Customer Create</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/edit?customerId=">Customer Edit</a></li>
                    </ul>
                </li>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="adminDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Admin
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="adminDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
                        </ul>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAuthority('USER')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            User
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                            <li><span class="dropdown-item"><sec:authentication property="name"/></span></li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
