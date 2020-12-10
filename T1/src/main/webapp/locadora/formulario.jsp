<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="messages">
	<head>
		<title><fmt:message key="locadora.form.title" /></title>
	</head>
	<body>
		<jsp:include page="../menuLogout.jsp"/>
		<div class="container-page">
		<div align="center">
			<h1><fmt:message key="locadora.form.management" /></h1>
		</div>
		<div align="center">
			<c:choose>
				<c:when test="${locadora != null}">
					<form action="${pageContext.request.contextPath}/locadoras/atualizacao" method="post">
						<%@include file="/locadora/campos.jsp"%>
					</form>
				</c:when>
				<c:otherwise>
					<form action="${pageContext.request.contextPath}/locadoras/insercao" method="post">
						<%@include file="/locadora/campos.jsp"%></form>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${!empty requestScope.mensagens}">
			<ul class="erro">
				<c:forEach items="${requestScope.mensagens}" var="mensagem">
					<li>${mensagem}</li>
				</c:forEach>
			</ul>
		</c:if>
		</div>
	</body>
    </fmt:bundle>
</html>