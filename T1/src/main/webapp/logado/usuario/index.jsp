<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<fmt:bundle basename="messages">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="logado.usuario.title" /></title>
    </head>
    <body>
        <h1><fmt:message key="logado.usuario.page" /></h1>
        <p>Olá ${sessionScope.usuarioLogado.nome}</p>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/clientes/locacoes"><fmt:message key="logado.usuario.rentals" /></a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="logado.usuario.logout" /></a>
            </li>
        </ul>
    </body>
    </fmt:bundle>
</html>