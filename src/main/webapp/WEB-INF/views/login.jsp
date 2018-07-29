<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="shared/staticDesign.jsp"%>
</head>
<body>


<div class="container">
    <div class="col-sm-3"></div>

    <h1>Login Page !!</h1>


    <sf:form class="form-horizontal" method="post"
             action="${pageContext.request.contextPath}/login" modelAttribute="user">
        <fieldset>

            <!-- Form Name -->
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Email</label>
                <div class="col-md-4">
                    <input id="textInput" name="email" type="text"
                           placeholder="Email" class="form-control input-md">

                    <sf:errors path="email" cssClass="alert-danger"></sf:errors>
                </div>
            </div>
            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password"
                           placeholder="password" class="form-control input-md">

                    <sf:errors path="password" cssClass="alert-danger"></sf:errors>
                </div>
            </div>

            <c:if test="${exit != null}">
                <div class="form-group">
                    <div class="col-md-8 alert alert-danger">
                        <spring:message code="error.invalid.user.password"/>
                    </div>
                </div>
            </c:if>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login"></label>
                <div class="col-md-4">
                    <button id="login" name="login" class="btn btn-primary">Login</button>
                </div>
            </div>

        </fieldset>

    </sf:form>
</div>

</body>
</html>