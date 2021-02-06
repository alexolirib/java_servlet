<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--JSP Java server page -->


<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso! <br>
		</c:if>
		
		<c:if test="${empty empresa }">
			Nenhuma empresa cadastrada! <br>
		</c:if>
		
	</body>
</html>