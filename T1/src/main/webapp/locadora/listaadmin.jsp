<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="messages">
	<head>
		<title><fmt:message key="locadora.listaAdmin.title" /></title>
	</head>
	<body>
			<%
		String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1><fmt:message key="locadora.listaAdmin.management" /></h1>
			<h2>
				<a href="${pageContext.request.contextPath}/admin/"><fmt:message key="locadora.listaAdmin.menuAdmin" /></a> &nbsp;&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/locadoras/cadastro"><fmt:message key="locadora.listaAdmin.newRental" /></a>
			</h2>
		</div>
		<div align="center">
			<table border="1">
				<caption><fmt:message key="locadora.listaAdmin.rentalList" /></caption>
				<tr>
					<th>ID</th>
					<th><fmt:message key="locadora.listaAdmin.name" /></th>
					<th><fmt:message key="locadora.listaAdmin.city" /></th>
					<th>Email</th>
					<th><fmt:message key="locadora.listaAdmin.password" /></th>
				</tr>
				<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
					<tr>
						<td>${locadora.id}</td>
						<td>${locadora.nome}</td>
						<td>${locadora.cidade}</td>
						<td>${locadora.login}</td>
						<td>${locadora.senha}</td>
						<td><a href="${pageContext.request.contextPath}/locadoras/edicao?id=${locadora.id}"><fmt:message key="locadora.listaAdmin.edit" /></a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="${pageContext.request.contextPath}/locadoras/remocao?id=${locadora.id}" onclick="return confirm('<fmt:message key="locadora.listaAdmin.confirm" />');"><fmt:message key="locadora.listaAdmin.remove" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
    </fmt:bundle>
</html>