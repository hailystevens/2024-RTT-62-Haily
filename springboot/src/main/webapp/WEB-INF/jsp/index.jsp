<jsp:include page="include/header.jsp"/>

<h1>This is my first JSP page!</h1>
<h2>${message}</h2>

<table>
    <tr>
        <td>id</td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>code</td>
        <td>${product.productCode}</td>
    </tr>
    <tr>
        <td>name</td>
        <td>${product.productName}</td>
    </tr>
    <tr>
        <td>description</td>
        <td>${product.productDescription}</td>
    </tr>
</table>

<jsp:include page="include/footer.jsp"/>
