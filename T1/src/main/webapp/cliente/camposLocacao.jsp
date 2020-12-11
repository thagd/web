<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${locacao != null}">
Edição de Locação
</c:when>
			<c:otherwise>
Cadastro de Locação
</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${locacao != null}">
		<input type="hidden" name="id" value="${locacao.id}" />
	</c:if>

	<tr>
		<td><label for="locadora">Locadora</label></td>
		<td>
			<select id="locadora" name="locadora">
				<c:forEach var="loc" items="${requestScope.listaLocadoras}">
					<c:if test="${loc.nome == locacao.locadora}">
						<option value="${loc.nome}" selected>${loc.nome}</option>
					</c:if>
					<c:if test="${loc.nome != locacao.locadora}">
						<option value="${loc.nome}">${loc.nome}</option>
					</c:if>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td><label for="data">Data</label></td>
		<td><input type="text" id="data" name="data" required size="10" maxlength="10"
			value="${locacao.data}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>