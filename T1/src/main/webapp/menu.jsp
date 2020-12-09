<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<fmt:bundle basename="messages">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="menu.title" /></title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-menu">
            <a href="${pageContext.request.contextPath}/index.jsp"><img src="img/Logo.png" width="50%" height="50%"></a>
            <div class="container-button-menu">
                <a class="container-button-login" href="${pageContext.request.contextPath}/log.jsp">Login</a>
            </div>
        </div>
    </body>
    </fmt:bundle>
</html>