
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List!</title>

    <%@ include file="shared/staticDesign.jsp"%>

</head>
<body>


<div class="container">
    <%@ include file="shared/nabvar.jsp"%>
    <br/><br/><br/>
    <div class="col-md-12 col-md-offset-3">
        <table class="table table-striped">
            <tr>

                <th>Name</th>
                <th>Price</th>
                <th>Profit Percentage</th>
                <th>ProductType</th>
                <th>Sold Count</th>
                <th>Action</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><c:out value="${product.name}"></c:out></td>
                    <td><c:out value="${product.price}"></c:out></td>
                    <td><c:out value="${product.profitPercentage}"></c:out></td>
                    <td><c:out value="${product.productType}"></c:out></td>
                    <td><c:out value="${product.soldCount}"></c:out></td>
                    <td><a
                            href="${pageContext.request.contextPath}/editProduct/${product.id}">Edit</a>
                        |

                        <a href="${pageContext.request.contextPath}/deleteProduct/${product.id}"
                        onclick="return confirm('Are you sure you want to delete this item?');">

                            Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

