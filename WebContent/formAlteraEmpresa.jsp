<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/alterarEmpresa" var="AlterarEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form action="${AlterarEmpresa}" method="post">
    
		<input type="hidden" name="id" value="${empresa.id}"  />
        Nome: <input type="text" name="nome" value="${empresa.nome}" />
        <br>
        Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		
        <input type="submit" />
    </form>

</body>
</html>