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
    <title>Make new order</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/make-order-post" method="POST">
        <p><fmt:message key="input.departure.address" /></p>
        <label class="sr-only" for="departureAddress"></label>
        <input placeholder="<fmt:message key="departure.address" />" class="form-control" type="text" id="departureAddress" name="departureAddress" required autofocus value="<c:out value='${orderDto.departureAddress}'/>">
        <c:if test="${fields.contains('departureAddress')}">
            <span style="color: red"><fmt:message key="address.error" /></span>
        </c:if>
        <br/>

        <p><fmt:message key="input.destination.address" /></p>
        <label class="sr-only" for="destinationAddress"></label>
        <input placeholder="<fmt:message key="destination.address" />" class="form-control" type="text" id="destinationAddress" name="destinationAddress" required autofocus value="<c:out value='${orderDto.destinationAddress}'/>">
        <c:if test="${fields.contains('destinationAddress')}">
            <span style="color: red"><fmt:message key="address.error" /></span>
        </c:if>
        <br/>

        <p><fmt:message key="input.number.of.passengers" /></p>
        <label class="sr-only" for="passengers"></label>
        <input type="number" class="form-control" id="passengers" name="passengers" min="1" max="7" value='1'/>
        <c:if test="${fields.contains('passengers')}">
            <span style="color: red" ><fmt:message key="passengers.error" /></span>
        </c:if>
        <br/>

        <p><fmt:message key="choose.car.category" /></p>
        <label class="sr-only" for="categories"></label>
        <select class="form-control" id="categories" name="category">
            <c:forEach items="${categories}" var="category">
                <option value="${category}">
                    ${category}: ${category.kmPrice}
                    <fmt:message key="price.per.km.lowerCase" />
                </option>
            </c:forEach>
        </select>
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="new-order.submit" /></button>
    </form>
</div>

</body>
</html>