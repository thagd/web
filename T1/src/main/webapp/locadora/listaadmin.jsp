<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Livraria Virtual</title>
</head>
<body>
	<%
String contextPath = request.getContextPath().replace("/", "");
%>
	<div align="center">
		<h1>Gerenciamento de Livros</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/admin/">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/locadoras/cadastro">Adicione Nova Locadora</a>
		</h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de Locadoras</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Email</th>
				<th>Senha</th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.id}</td>
					<td>${locadora.nome}</td>
					<td>${locadora.cidade}</td>
					<td>${locadora.email}</td>
					<td>${locadora.senha}</td>
					<td><a href="${pageContext.request.contextPath}/locadoras/edicao?id=${locadora.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath}/locadoras/remocao?id=${locadora.id}" onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>