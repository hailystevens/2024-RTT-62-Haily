<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/"><img src="/pub/images/Classic_Models_Search_Engine_transparent.png" style="width: 100px" alt="Brand Logo"></a>
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
                        <li><a class="dropdown-item" href="/admin/dashboard.jsp">Dashboard</a></li>
                    </ul>
                </li>

                <!-- Auth Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="authDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Auth
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="authDropdown">
                        <li><a class="dropdown-item" href="/auth/create-account.jsp">Create Account</a></li>
                        <li><a class="dropdown-item" href="/auth/login.jsp">Login</a></li>
                    </ul>
                </li>

                <!-- Customer Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="customerDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="customerDropdown">
                        <li><a class="dropdown-item" href="/customer/create.jsp">Create Customer</a></li>
                        <li><a class="dropdown-item" href="/customer/detail.jsp">Customer Detail</a></li>
                        <li><a class="dropdown-item" href="/customer/list.jsp">Customer List</a></li>
                        <li><a class="dropdown-item" href="/customer/list-by-employee.jsp">Customers by Employee</a></li>
                        <li><a class="dropdown-item" href="/customer/search.jsp">Search Customers</a></li>
                    </ul>
                </li>

                <!-- Employee Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="employeeDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Employee
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="employeeDropdown">
                        <li><a class="dropdown-item" href="/employee/create.jsp">Create Employee</a></li>
                        <li><a class="dropdown-item" href="/employee/detail.jsp">Employee Detail</a></li>
                        <li><a class="dropdown-item" href="/employee/list.jsp">Employee List</a></li>
                        <li><a class="dropdown-item" href="/employee/search.jsp">Search Employees</a></li>
                    </ul>
                </li>

                <!-- Office Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="officeDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Office
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="officeDropdown">
                        <li><a class="dropdown-item" href="/office/create.jsp">Create Office</a></li>
                        <li><a class="dropdown-item" href="/office/detail.jsp">Office Detail</a></li>
                        <li><a class="dropdown-item" href="/office/list.jsp">Office List</a></li>
                    </ul>
                </li>

                <!-- Order Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="orderDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Order
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="orderDropdown">
                        <li><a class="dropdown-item" href="/order/detail.jsp">Order Detail</a></li>
                        <li><a class="dropdown-item" href="/order/list.jsp">Order List</a></li>
                        <li><a class="dropdown-item" href="/order/list-by-customer.jsp">Orders by Customer</a></li>
                        <li><a class="dropdown-item" href="/order/search.jsp">Search Orders</a></li>
                    </ul>
                </li>

                <!-- Order Detail Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="orderDetailDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Order Detail
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="orderDetailDropdown">
                        <li><a class="dropdown-item" href="/order-detail/detail.jsp">Order Detail</a></li>
                        <li><a class="dropdown-item" href="/order-detail/list.jsp">Order Detail List</a></li>
                        <li><a class="dropdown-item" href="/order-detail/list-by-order.jsp">Order Details by Order</a></li>
                    </ul>
                </li>

                <!-- Product Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="productDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Product
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="productDropdown">
                        <li><a class="dropdown-item" href="/product/create.jsp">Create Product</a></li>
                        <li><a class="dropdown-item" href="/product/detail.jsp">Product Detail</a></li>
                        <li><a class="dropdown-item" href="/product/edit.jsp">Edit Product</a></li>
                        <li><a class="dropdown-item" href="/product/list.jsp">Product List</a></li>
                        <li><a class="dropdown-item" href="/product/search.jsp">Search Products</a></li>
                    </ul>
                </li>

                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/login.jsp">Log In</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/logout.jsp">Log Out</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
