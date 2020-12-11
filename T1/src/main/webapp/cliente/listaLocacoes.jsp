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
		<h1>Gerenciamento de Locacoes</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/usuario/">Menu User</a> &nbsp;&nbsp;&nbsp; 
			<a href="${pageContext.request.contextPath}/clientes/cadastrolocacao">Adicione Nova Locação</a>
		</h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de Locações</caption>
			<tr>
				<th>Locadora</th>
				<th>Data</th>
			</tr>
			<c:forEach var="locacao" items="${requestScope.listaLocacoes}">
				<tr>
					<td>${locacao.locadora}</td>
					<td>${locacao.data}</td>
					<td><a href="${pageContext.request.contextPath}/clientes/edicaolocacao?id=${locacao.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath}/clientes/remocaolocacao?id=${locacao.id}" onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>