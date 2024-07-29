<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><c:out value="${title}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pub/css/global.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/product/search">Search Products</a></li>
            <li><a href="${pageContext.request.contextPath}/product/list">View Products</a></li>
            <li><a href="${pageContext.request.contextPath}/product/create">Create Product</a></li>
            <li><a href="${pageContext.request.contextPath}/employee/search">Search Employees</a></li>
            <li><a href="${pageContext.request.contextPath}/employee/list">View Employees</a></li>
            <li><a href="${pageContext.request.contextPath}/employee/create">Create Employee</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/list">View Customers</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/create">Create Customer</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/search">Search Customers</a></li>
            <li><a href="${pageContext.request.contextPath}/order/search">Search Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/order/list">View Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/order/create">Create Order</a></li>
            <li><a href="${pageContext.request.contextPath}/auth/login">Login</a></li>
        </ul>
    </nav>
</header>
