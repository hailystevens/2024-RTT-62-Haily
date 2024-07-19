<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<div class="container">
    <div class="row justify-content-center pt-5">
        <div class="col-8 text-center">
            <h1>This is my first JSP page</h1>
            <h2>${message}</h2>
        </div>
    </div>

    <div class="row justify-content-center pt-3">
        <div class="col-8">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Field</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>ID</td>
                    <td>${productKey.id}</td>
                </tr>
                <tr>
                    <td>Code</td>
                    <td>${productKey.productCode}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>${productKey.productName}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${productKey.productDescription}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
