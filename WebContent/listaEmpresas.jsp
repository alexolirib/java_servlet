<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List, br.com.estudo.gerenciador.domain.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Lista de empresas: <br>
	<ul>
		<% 
		List<Empresa> listaEmpresa = (List<Empresa>)request.getAttribute("empresas");
		for(Empresa empresa: listaEmpresa) {
		%>
			
		<li>ID - <%=empresa.getId() %>,  Empresa - <%=empresa.getNome() %></li>
		<%
		}
		 %>
	</ul>
</body>
</html>