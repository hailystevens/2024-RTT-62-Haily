<jsp:include page="../include/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">


<h1>Order Details</h1>


<div class="tableBackground">
    <div class="container">
        <div class="row justify-content-center">

            <div class="col-auto">
                <table class="table table-responsive" style="width: 750pt">
                    <tr>
                        <td style="font-weight: bolder;">Order ID:</td>
                        <td>${orderKey.id}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Customer ID:</td>
                        <td>${orderKey.customerID}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Order Date:</td>
                        <td>${orderKey.orderDate}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Required Date:</td>
                        <td>${orderKey.requiredDate}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Shipped Date:</td>
                        <td>${orderKey.shippedDate}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Status:</td>
                        <td>${orderKey.status}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Comments:</td>
                        <td>${orderKey.comments}</td>
                    </tr>


                </table>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../include/footer.jsp"/>
