<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora Virtual</title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container-page">
            <h1 align="center">Locadora Virtual</h1>
            <div align="center">
            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <div> ${erro} </div>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="post" action="log.jsp">
                <label class='text-formulario'>Login</label><br/>
                <input class='input' type="text" name="login" value="${param.login}"/><br/>
                <label class='text-formulario'>Senha</label><br/>
                <input class='input' type="password" name="senha" /><br/>
                <input type="submit" name="bOK" value="Entrar"/><br/>
            </form>
            </div>
        </div>
        </body>
        </html>
       