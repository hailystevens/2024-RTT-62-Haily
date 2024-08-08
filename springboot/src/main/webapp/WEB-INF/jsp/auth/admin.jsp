<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp" />

<div class="container">
    <h2>Admin Dashboard</h2>

    <sec:authorize access="isAuthenticated()">
        <p>Welcome, authenticated user!</p>
    </sec:authorize>

    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
        <p>Admin Area: Only users with admin authority can see this.</p>
    </sec:authorize>

    <!-- Add your admin page content here -->

</div>

<jsp:include page="../include/footer.jsp" />
