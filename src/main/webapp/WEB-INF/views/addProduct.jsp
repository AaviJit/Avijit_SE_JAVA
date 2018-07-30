<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Save Product</title>
    <%@ include file="shared/staticDesign.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="shared/nabvar.jsp" %>
    <br/><br/><br/><br/>

    <sf:form class="form-horizontal"
             action="${pageContext.request.contextPath}/addproduct"
             method="post" modelAttribute="product">
        <fieldset>

            <!-- Form Name -->
            <legend>Add Product !</legend>


            <div class="form-group">
                <label class="col-md-4 control-label" for="id"></label>
                <div class="col-md-4">
                    <sf:input id="id" path="id" name="id" type="hidden"
                              placeholder="id" class="form-control input-md"></sf:input>

                    <sf:errors path="id" cssClass="alert-danger"></sf:errors>

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Product Name</label>
                <div class="col-md-4">
                    <sf:input id="name" path="name" name="name" type="text"
                              placeholder="name" class="form-control input-md"></sf:input>

                    <sf:errors path="name" cssClass="alert-danger"></sf:errors>


                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <sf:input id="price" path="price" name="price"
                              type="text" placeholder="Price" class="form-control input-md"></sf:input>
                    <sf:errors path="price" cssClass="alert-danger"></sf:errors>
                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="profitPercentage">Profit Percentage
                </label>
                <div class="col-md-4">
                    <sf:input id="profitPercentage" path="profitPercentage" name="profitPercentage"
                              type="text" placeholder="profitPercentage" class="form-control input-md"></sf:input>
                    <sf:errors path="profitPercentage" cssClass="alert-danger"></sf:errors>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="productType">Product Type</label>
                <div class="col-md-4">
                    <select id="productType" name="productType" class="form-control">
                        <option value="RAM">RAM</option>
                        <option value="MOTHERBOARD">MOTHERBOARD</option>
                        <option value="GRAPHICS CARD">GRAPHICS CARD</option>
                    </select>
                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="soldCount">Sold Count
                </label>
                <div class="col-md-4">
                    <sf:input id="soldCount" path="soldCount" name="soldCount" type="text"
                              placeholder="soldCount" class="form-control input-md"></sf:input>
                    <sf:errors path="soldCount" cssClass="alert-danger"></sf:errors>
                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="save"></label>
                <div class="col-md-4">


                    <c:choose>
                        <c:when test="${product.id gt 0}">
                            <button id="update" name="update" class="btn btn-primary">Update</button>
                        </c:when>

                        <c:otherwise>
                            <button id="save" name="create" class="btn btn-primary">Save</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </fieldset>
    </sf:form>
</div>
</body>
</html>