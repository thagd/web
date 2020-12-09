<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="messages">
	<head>
		<title><fmt:message key="locadora.lista.title" /></title>
	</head>
	<body>
		<jsp:include page="../menu.jsp"/>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div class="container-page">
			<form action="${pageContext.request.contextPath}/locadoras/listaCidade" method="post">
				<label for="cidade"><fmt:message key="locadora.lista.city" /></label>
				<input type="text" id="cidade" name="cidade" required size="30" maxlength="30"/>
				<input type="submit" value="<fmt:message key="locadora.lista.search" />" />
			</form>
			
			<h1 align="center"><fmt:message key="locadora.lista.rentalList" /></h1>
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
    </fmt:bundle>
</html>