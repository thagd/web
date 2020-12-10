<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="messages">
	<head>
		<title><fmt:message key="cliente.listaLocacoes.title" /></title>
	</head>
	<body>
		<%
	String contextPath = request.getContextPath().replace("/", "");
	%>
		<div align="center">
			<h1><fmt:message key="cliente.listaLocacoes.management" /></h1>
			<h2>
				<a href="${pageContext.request.contextPath}/usuario/"><fmt:message key="cliente.listaLocacoes.menuUser" /></a> &nbsp;&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/clientes/cadastro"><fmt:message key="cliente.listaLocacoes.newRental" /></a>
			</h2>
		</div>
		<div align="center">
			<table border="1">
				<caption><fmt:message key="cliente.listaLocacoes.rentalList" /></caption>
				<tr>
					<th><fmt:message key="cliente.listaLocacoes.rentalCompany" /></th>
					<th><fmt:message key="cliente.listaLocacoes.date" /></th>
				</tr>
				<c:forEach var="locacao" items="${requestScope.listaLocacoes}">
					<tr>
						<td>${locacao.locadora}</td>
						<td>${locacao.data}</td>
						<td><a href="${pageContext.request.contextPath}/clientes/edicao?id=${cliente.id}"><fmt:message key="cliente.listaLocacoes.edit" /></a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="${pageContext.request.contextPath}/clientes/remocao?id=${cliente.id}" onclick="return confirm('<fmt:message key="cliente.listaLocacoes.confirm" />');"><fmt:message key="cliente.listaLocacoes.remove" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
    </fmt:bundle>
</html>