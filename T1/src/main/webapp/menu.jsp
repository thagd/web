<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação de Usuário</title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-menu">
            <a href="${pageContext.request.contextPath}/index.jsp"><h3 class="logo">Aluga Bike</h3></a>
            <div class="container-button-menu">
                <a class="container-button-signup" href="${pageContext.request.contextPath}/log.jsp">Sign up</a>
                <a class="container-button-login" href="${pageContext.request.contextPath}/log.jsp">Login</a>
            </div>
        </div>
    </body>
</html>