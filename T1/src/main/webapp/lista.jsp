<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Locadora Virtual</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Locadora de Livros</h1>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de Locadoras</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cidade</th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.id}</td>
					<td>${locadora.nome}</td>
					<td>${locadora.cidade}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>