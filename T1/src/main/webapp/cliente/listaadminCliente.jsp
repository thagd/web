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
		<h1>Gerenciamento de Clientes</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/admin/">Menu Admin</a> &nbsp;&nbsp;&nbsp; 
			<a href="${pageContext.request.contextPath}/clientes/cadastro">Adicione Novo Cliente</a>
		</h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de Clientes</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.login}</td>
					<td>${cliente.senha}</td>
					<td><a href="${pageContext.request.contextPath}/clientes/edicao?id=${cliente.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath}/clientes/remocao?id=${cliente.id}" onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>