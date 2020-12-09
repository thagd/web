<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="messages">
	<head>
		<title><fmt:message key="cliente.listaAdmin.title" /></title>
	</head>
	<body>
			<%
		String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1><fmt:message key="cliente.listaAdmin.management" /></h1>
			<h2>
				<a href="${pageContext.request.contextPath}/admin/"><fmt:message key="cliente.listaAdmin.menuAdmin" /></a> &nbsp;&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/clientes/cadastro"><fmt:message key="cliente.listaAdmin.newClient" /></a>
			</h2>
		</div>
		<div align="center">
			<table border="1">
				<caption><fmt:message key="cliente.listaAdmin.clientList" /></caption>
				<tr>
					<th>ID</th>
					<th><fmt:message key="cliente.listaAdmin.name" /></th>
					<th>Email</th>
					<th><fmt:message key="cliente.listaAdmin.password" /></th>
				</tr>
				<c:forEach var="cliente" items="${requestScope.listaClientes}">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.login}</td>
						<td>${cliente.senha}</td>
						<td><a href="${pageContext.request.contextPath}/clientes/edicao?id=${cliente.id}"><fmt:message key="cliente.listaAdmin.edit" /></a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="${pageContext.request.contextPath}/clientes/remocao?id=${cliente.id}" onclick="return confirm('<fmt:message key="cliente.listaAdmin.confirm" />');"><fmt:message key="cliente.listaAdmin.remove" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
    </fmt:bundle>
</html>