<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file = "/WEB-INF/jspf/style.jspf"%>
    <title>Prices</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>
<div class="form-signin">
    <table class="table table-bordered caption-top">
        <caption><fmt:message key="cars.prices" /></caption>
        <tr>
            <th><fmt:message key="category" /></th>
            <th><fmt:message key="price.per.km" /></th>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category}</td>
                <td>${category.kmPrice}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${user != null}">
        <div>
            <a href = "${pageContext.request.contextPath}/make-order" class = "btn btn-lg btn-primary btn-block"><fmt:message key="make.order" /></a>
        </div>
    </c:if>

    <c:if test="${user == null}">
        <div>
            <h1><fmt:message key="to.make.order" /></h1>
            <a href = "${pageContext.request.contextPath}/login" class = "btn btn-lg btn-primary btn-block"><fmt:message key="login" /></a>
            <h3>NO ACCOUNT?</h3>
            <a href = "${pageContext.request.contextPath}/registration" class = "btn btn-lg btn-primary btn-block"><fmt:message key="register" /></a>
        </div>
    </c:if>

</div>
</body>
</html>