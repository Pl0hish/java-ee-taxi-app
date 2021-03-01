<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file = "/WEB-INF/jspf/style.jspf"%>
    <title>Confirmation page</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>

<div class="form-signin">
    <h2><fmt:message key="car.arrives" />${' ' + timeToWait + ' '}<fmt:message key="minutes" /></h2>
    <a href="${pageContext.request.contextPath}/main" class="btn btn-lg btn-primary btn-block"><fmt:message key="return.main" /></a>
</div>

</body>
</html>