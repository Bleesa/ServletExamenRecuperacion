<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar propietario</title>
</head>
<body>
<%
 Object name=request.getAttribute("name");
pageContext.setAttribute("name", name);

%>
	<form action="/updatePet" method="post">
		<span>Nombre mascota</span><input type="text" name="name" value="<c:out value="${pet.name}"/>" >
		<input type="hidden" name="codOwner" value="<c:out value="${pet.codOwner}"/>" >
		<input type="hidden" name="antiguoName" value="<c:out value="${name}"/>" >
		<input type="submit">
	</form>
</body>
</html>