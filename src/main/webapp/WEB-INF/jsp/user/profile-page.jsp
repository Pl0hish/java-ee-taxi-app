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
    <title>Profile page</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>

<div class="container">
    <table class="table table-bordered caption-top">
        <caption><fmt:message key="profile.info" /></caption>
        <tr>
            <th><fmt:message key="first.name" /></th>
            <td><c:out value='${user.firstName}'/></td>
        </tr>
        <tr>
            <th><fmt:message key="last.name" /></th>
            <td><c:out value='${user.lastName}'/></td>
        </tr>
        <tr>
            <th><fmt:message key="email" /></th>
            <td><c:out value='${user.email}'/></td>
        </tr>
        <tr>
            <th><fmt:message key="spent.money" /></th>
            <td><c:out value='${user.spentMoney}'/></td>
        </tr>
    </table>

    <table class="table table-bordered caption-top">
        <caption><fmt:message key="your.orders" /></caption>
        <tr>
            <th><fmt:message key="date" /></th>
            <th><fmt:message key="departure.address" /></th>
            <th><fmt:message key="destination.address" /></th>
            <th><fmt:message key="distance" /></th>
            <th><fmt:message key="passengers" /></th>
            <th><fmt:message key="category" /></th>
            <th><fmt:message key="price" /></th>
        </tr>

        <c:forEach items="${userOrders}" var="order">
            <tr>
                <td>${order.date}</td>
                <td>${order.departureAddress}</td>
                <td>${order.destinationAddress}</td>
                <td>${order.distance}</td>
                <td>${order.passengers}</td>
                <td>${order.carCategory}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>