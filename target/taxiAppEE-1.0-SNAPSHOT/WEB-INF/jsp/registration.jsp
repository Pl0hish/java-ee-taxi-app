<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <%@ include file = "/WEB-INF/jspf/style.jspf"%>
    <title>Registration</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/registration-post" method="POST">
        <p><fmt:message key="input.first.name" /></p>
        <label class="sr-only" for="firstName"></label>
        <input name="firstName" placeholder="<fmt:message key="first.name" />" class="form-control" type="text" id="firstName" required autofocus value="<c:out value='${userDto.firstName}'/>">
        <c:if test="${fields.contains('firstName')}">
            <span style="color: red"><fmt:message key="firstName.error" /></span>
        </c:if>
        <br/>

        <p><fmt:message key="input.last.name" /></p>
        <label class="sr-only" for="lastName"></label>
        <input name="lastName" placeholder="<fmt:message key="last.name" />" class="form-control" type="text" id="lastName" required autofocus value="<c:out value='${userDto.lastName}'/>">
        <c:if test="${fields.contains('lastName')}">
            <span style="color: red"><fmt:message key="lastName.error" /></span>
        </c:if>
        <br/>

        <p><fmt:message key="input.email" /></p>
        <label for="email"></label>
        <input name="email" placeholder="<fmt:message key="email" />" class="form-control" type="email" id="email" required autofocus value="<c:out value='${userDto.email}'/>">
        <c:if test="${fields.contains('email')}">
            <span style="color: red"><fmt:message key="email.error" /></span>
        </c:if>
        <c:if test="${exception != null}">
            <span style="color: red"><fmt:message key="email.exists" /></span>
        </c:if>
        <br/>

        <p><fmt:message key="input.password" /></p>
        <label for="password"></label>
        <input name="password" placeholder="<fmt:message key="password" />" class="form-control" type="password" id="password" required autofocus value="<c:out value='${userDto.password}'/>">
        <c:if test="${fields.contains('password')}">
            <span style="color: red"><fmt:message key="password.error" /></span>
        </c:if>
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="registration.submit" /></button>
    </form>
</div>

</body>
</html>