<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${cliente != null}">
Edição de Usuário
</c:when>
			<c:otherwise>
Cadastro de Usuário
</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${cliente != null}">
		<input type="hidden" name="id" value="${cliente.id}" />
	</c:if>

	<tr>
		<td><label for=nome>Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="30"
			required value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="30" required
			value="${cliente.login}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" required size="8" maxlength="8"
			value="${cliente.senha}" /></td>
	</tr>
	<tr>
		<input type="hidden" name="papel" value="CLIENTE" />
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>