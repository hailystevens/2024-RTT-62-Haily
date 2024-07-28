<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product Details</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-3">
            <div class="col-12">
                <c:if test="${not empty product}">
                    <p><strong>ID:</strong> ${product.id}</p>
                    <p><strong>Code:</strong> ${product.productCode}</p>
                    <p><strong>Name:</strong> ${product.productName}</p>
                    <p><strong>Description:</strong> ${product.productDescription}</p>
                </c:if>
                <c:if test="${empty product}">
                    <p>Product not found.</p>
                </c:if>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>
