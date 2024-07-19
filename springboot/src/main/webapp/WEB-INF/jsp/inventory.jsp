<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<script>
    function handleChange() {
        let number = document.getElementById("id").value;
        window.location.assign("/item/" + number);
    }
</script>

<!-- Search Form -->
<div class="container">
    <section>
        <div class="row">
            <div class="col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col-8">
                <form action="/inventory/search" method="get">
                    <div class="mb-3">
                        <label for="name" class="form-label"><h4>Inventory Search</h4></label>
                        <input name="search" id="name" type="text" class="form-control" value="${name}" placeholder="Enter name here" aria-describedby="nameHelp">
                        <small id="nameHelp" class="form-text text-muted">Enter the product name to search in the inventory.</small>
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>

    <!-- Search Results -->
    <section>
        <div class="row justify-content-center">
            <div class="col-8">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Item Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td><a href="/item/${product.id}">${product.productName}</a></td>
                            <td>${product.productDescription}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>

<jsp:include page="include/footer.jsp" />
