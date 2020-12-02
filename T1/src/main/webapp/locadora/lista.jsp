<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Locação de Bikes</title>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div class="container-page">
		<h1 align="center">Lista de Locadoras</h1>
		<div align="center">
			<c:forEach var="loc" items="${requestScope.listaLocadoras}">
				<div class="container-lista" >
					<div class="title-card">${loc.nome}</div>
					${loc.cidade}
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>