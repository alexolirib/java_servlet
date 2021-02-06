<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List, br.com.estudo.gerenciador.domain.Empresa" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/formNovaEmpresa.jsp" var="novaEmpresa"/>
<c:url value="/removeEmpresa" var="removeEmpresa"/>
<c:url value="/alterarEmpresa" var="alterarEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - Java Standard Taglib</title>
</head>
<body>
	<!-- Com o jar jstl -->
	<a href="${novaEmpresa }">Cadastrar Nova Empresa</a>
	<br>
	Lista de empresas: <br>
	
	<ul>
		<c:forEach items="${empresas }" var="empresa">
			<li>
				ID - ${empresa.id},  Empresa - ${empresa.nome}, Abertura - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
				<a href="${alterarEmpresa }?id=${empresa.id}">Alterar</a>
				<a href="${removeEmpresa }?id=${empresa.id}">Remover</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>