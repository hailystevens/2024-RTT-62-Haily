<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-12 text-center">
            <h1>${message}</h1>
            <p>Your account has been successfully created. You are now signed in.</p>
            <a href="${pageContext.request.contextPath}/home" class="btn btn-primary">Go to Home</a>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>
