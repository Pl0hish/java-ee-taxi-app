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
    <title>Admin panel</title>
</head>
<body>
<%@ include file = "/WEB-INF/jspf/header.jspf"%>
<%@ include file = "/WEB-INF/jspf/admin-panel.jspf"%>
</body>
</html>