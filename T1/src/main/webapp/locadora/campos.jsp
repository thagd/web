<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:bundle basename="messages">
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${locadora != null}">
<fmt:message key="locadora.campos.edit" />
</c:when>
			<c:otherwise>
<fmt:message key="locadora.campos.register" />
</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${locadora != null}">
		<input type="hidden" name="id" value="${locadora.id}" />
	</c:if>
	<tr>
		<td><label for=nome><fmt:message key="locadora.campos.name" /></label></td>
		<td><input type="text" id="nome" name="nome" size="30"
			required value="${locadora.nome}" /></td>
	</tr>
	<tr>
		<td><label for="cidade"><fmt:message key="locadora.campos.city" /></label></td>
		<td><input type="text" id="cidade" name="cidade" size="20" required
			value="${locadora.cidade}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="30" required
			value="${locadora.login}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="locadora.campos.password" /></label></td>
		<td><input type="text" id="senha" name="senha" required size="8" maxlength="8"
			value="${locadora.senha}" /></td>
	</tr>
	<tr>
		<input type="hidden" name="papel" value="LOCADORA" />
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="locadora.campos.save" />" /></td>
	</tr>
</table>
</fmt:bundle>