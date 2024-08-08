
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 mx-auto rounded border p-4 m-4">
            <h2 class="text-center mb-5">Edit Product</h2>

            <form:form action="${pageContext.request.contextPath}/product/edit" modelAttribute="product" method="post" enctype="multipart/form-data">
                <form:hidden path="id" />

                <div class="row mb-3">
                    <label class="col-sm-4 col-form-label">Product Name</label>
                    <div class="col-sm-8">
                        <form:input path="name" class="form-control" />
                        <form:errors path="name" cssClass="text-danger" />
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-4 col-form-label">Product Vendor</label>
                    <div class="col-sm-8">
                        <form:input path="brand" class="form-control" />
                        <form:errors path="brand" cssClass="text-danger" />
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-4 col-form-label">Product Line ID</label>
                    <div class="col-sm-8">
                        <form:input path="category" class="form-control" />
                        <form:errors path="category" cssClass="text-danger" />
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-4 col-form-label">Price</label>
                    <div class="col-sm-8">
                        <form:input path="price" type="number" step="0.01" min="0" class="form-control" />
                        <form:errors path="price" cssClass="text-danger" />
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-4 col-form-label">Description</label>
                    <div class="col-sm-8">
                        <form:textarea path="description" class="form-control" />
                        <form:errors path="description" cssClass="text-danger" />
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-4 col-form-label">Image</label>
                    <div class="col-sm-8">
                        <form:input path="imageFileName" type="file" class="form-control" />
                        <form:errors path="imageFileName" cssClass="text-danger" />
                    </div>
                </div>

                <div class="row">
                    <div class="offset-sm-4 col-sm-4 d-grid">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>
                    <div class="col-sm-4 d-grid">
                        <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/product/list" role="button">Cancel</a>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

<jsp:include page="../include/footer.jsp" />
