<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<fmt:bundle basename="messages">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="logado.admin.title" /></title>
    </head>
    <body>
		<jsp:include page="../../menuLogout.jsp"/>
		<div class="container-page">
        <h1><fmt:message key="logado.admin.page" /></h1>
        <p>Olá ${sessionScope.usuarioLogado.nome}</p>
        <ul>
            <li>
            	<a href="${pageContext.request.contextPath}/locadoras/listaadmin"><fmt:message key="logado.admin.rentalManagement" /></a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/clientes/listaadmin"><fmt:message key="logado.admin.userManagement" /></a>
        	</li>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="logado.admin.logout" /></a>
            </li>
        </ul>
		</div>
    </body>
    </fmt:bundle>
</html>