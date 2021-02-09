<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List,br.com.estudo.gerenciador.model.Empresa" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="entrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - Java Standard Taglib</title>
</head>
<body>
	<!-- Com o jar jstl -->
	<a href="${entrada }?acao=FormNovaEmpresa">Cadastrar Nova Empresa</a>
	<br>
	Lista de empresas: <br>
	
	<ul>
		<c:forEach items="${empresas }" var="empresa">
			<li>
				ID - ${empresa.id},  Empresa - ${empresa.nome}, Abertura - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
				<a href="${entrada }?acao=EditEmpresa&id=${empresa.id}">Alterar</a>
				<a href="${entrada }?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>