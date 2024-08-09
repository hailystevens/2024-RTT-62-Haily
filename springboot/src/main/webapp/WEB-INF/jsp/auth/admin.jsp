<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp"/>

<div class="container">
    <h2>Admin Dashboard</h2>

    <sec:authorize access="isAuthenticated()"> <!-- Requirement: JSP < sec:authorize> for isAuthenticated -->
        <p>Welcome, authenticated user!</p>
    </sec:authorize>

    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
        <p>Admin Area: Only users with admin authority can see
            this.</p><!-- Requirement: JSP < sec:authorize> for isAnyAuthority -->
    </sec:authorize>

    <!-- Add page content here -->

</div>

<jsp:include page="../include/footer.jsp"/>
