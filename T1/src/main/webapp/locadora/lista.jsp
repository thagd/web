<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Locação de Bikes</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Lista de Locadoras</h1>
	</div>

	<div id="box" align="center" >
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Email</th>
			</tr>
			<c:forEach var="loc" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${loc.id}</td>
					<td>${loc.nome}</td>
					<td>${loc.cidade}</td>
					<td>${loc.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>