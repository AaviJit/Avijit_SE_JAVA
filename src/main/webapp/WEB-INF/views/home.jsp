<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Online Shopping - Homepage</title>
    <%@ include file="shared/staticDesign.jsp"%>

</head>
<body>
<div class="container">
<%@ include file="shared/nabvar.jsp"%>
<br/><br/><br/>
<div class="col-md-12 col-md-offset-3">
    <h1>Product List with Higest Profit</h1>
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>ProductType</th>
            <th>Total Profil</th>
        </tr>
        <c:forEach var="product" items="${top5Product}">
            <tr>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.productType}"></c:out></td>
                <td><c:out value="${product.totalProfit}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>


    <div class="col-md-12 col-md-offset-3">
        <h1>Product List with Higest Sold</h1>
        <table class="table table-striped">
            <tr>

                <th>Name</th>
                <th>ProductType</th>
                <th>Sold Count</th>
            </tr>
            <c:forEach var="product" items="${top5Sold}">
                <tr>
                    <td><c:out value="${product.name}"></c:out></td>
                    <td><c:out value="${product.productType}"></c:out></td>
                    <td><c:out value="${product.soldCount}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>