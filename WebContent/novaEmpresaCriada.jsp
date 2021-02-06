<!--JSP Java server page -->
<%
String nomeEmpresa = (String)request.getAttribute("empresa");
%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
Empresa <%=nomeEmpresa %> cadastrada com sucesso! <br>
</body>
</html>