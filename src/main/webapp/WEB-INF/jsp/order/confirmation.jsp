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

<div class="container">
    <form class="form-signin" action="${pageContext.request.context Path}/confirmationPage-post" method="POST">
        <table class="table table-bordered caption-top">
            <caption><fmt:message key="your.order" /></caption>
            <tr>
                <th><fmt:message key="departure.address" /></th>
                <td>
                    <p>${confirmationOrder.departureAddress}</p>
                    <input type="text" readonly="readonly" name="departureAddress" hidden value="${confirmationOrder.departureAddress}">
                </td>
            </tr>
            <tr>
                <th><fmt:message key="destination.address" /></th>
                <td>
                    <p>${confirmationOrder.destinationAddress}</p>
                    <input type="text" readonly="readonly" name="destinationAddress" hidden value="${confirmationOrder.destinationAddress}">
                </td>
            </tr>
            <tr>
                <th><fmt:message key="distance" /></th>
                <td>
                    <p>${confirmationOrder.distance}</p>
                    <input type="number" readonly="readonly" name="distance" value="${confirmationOrder.distance}" hidden>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="passengers" /></th>
                <td>
                    <p>${confirmationOrder.passengers}</p>
                    <input type="text" name="passengers" readonly="readonly" hidden value="${confirmationOrder.passengers}">
                </td>
            </tr>
            <tr>
                <th><fmt:message key="category" /></th>
                <td>
                    <p>${confirmationOrder.carCategory}</p>
                    <input type="text" readonly="readonly" hidden name="category" value="${confirmationOrder.carCategory}">
                </td>
            </tr>
            <tr>
                <th><fmt:message key="price" /></th>
                <td>
                    <p>${confirmationOrder.price}</p>
                    <input type="text" readonly="readonly" hidden name="price" value="${confirmationOrder.price}">
                </td>
            </tr>
        </table>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="confirm" /></button>
    </form>
</div>

</body>
</html>