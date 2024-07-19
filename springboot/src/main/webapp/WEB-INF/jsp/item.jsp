<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp" />

<div class="container">
    <div class="row text-center pt-5">
        <div class="col-12">
            <h2>${product.productName}</h2>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <td>${product.id}</td>
                </tr>
                <tr>
                    <th>Code</th>
                    <td>${product.productCode}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${product.productName}</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>${product.productDescription}</td>
                </tr>
                <tr>
                    <th>MSRP</th>
                    <td>${product.msrp}</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <div class="col-8 text-center">
            <button class="btn btn-secondary" onclick="window.location.assign('/inventory')">Back</button>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
