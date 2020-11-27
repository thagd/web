<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">

<form action="buscaCidade" method="post">					
	<tr>
		<td><label for="cidade">Cidade</label></td>
		<td><input type="text" id="cidade" name="cidade" size="20" required
		value="${locadora.cidade}" /></td>
		<td colspan="2" align="center"><input type="submit" value="Busca" /></td>
	</tr>
</form>
	
	<c:forEach var="locadora" items="${requestScope.listaCidades}">
				<tr>
					<td>${locadora.id}</td>
					<td>${locadora.nome}</td>
					<td>${locadora.cidade}</td>
				</tr>
	</c:forEach>
			
</table>