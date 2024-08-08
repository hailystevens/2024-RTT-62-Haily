<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Account Created</h1>
            <div class="col-12 text-center">
                <c:if test="${not empty successMessage}">
                    <div class="alert alert-success" role="alert">
                            ${successMessage}
                    </div>
                </c:if>
                <a href="${pageContext.request.contextPath}/account/login" class="btn btn-primary">Go to Login</a>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
