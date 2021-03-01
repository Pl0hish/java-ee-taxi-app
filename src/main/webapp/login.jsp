<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <%@ include file = "/WEB-INF/jspf/style.jspf"%>
    <title>LOGIN PAGE</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>
<div class = "container">
    <form class = "form-signin" action = "${pageContext.request.contextPath}/login-post" method = "post">
        <c:if test="${exception != null}">
            <span style = "color: red"><fmt:message key="logging.error" /></span>
        </c:if>
        <p><fmt:message key="input.email" /></p>
        <label for = "email"></label>
        <input name = "email" class = "form-control" type = "text"  id = "email" required autofocus>
        <br/>

        <p><fmt:message key="input.password" /></p>
        <label for = "password"></label>
        <input name = "password" class = "form-control" type = "password" id = "password" required autofocus>
        <br/>
        <button class = "btn btn-lg btn-primary btn-block" type = "submit"><fmt:message key="login" /></button>
    </form>
</div>
</body>
</html>
