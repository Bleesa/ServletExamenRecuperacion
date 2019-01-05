<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Pelicula> listAllPeliculas = (List<Pelicula>)request.getAttribute("listAllPeliculas");
	%>



<table border="1">
	<thead>
		<tr>
			<td>Cod</td>
			<td>Title</td>
			<td>Asociar Actor</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pelicula" items="${listAllPeliculas}">
			<tr>
				<td><c:out value="${pelicula.COD}"/> </td>
				<td><c:out value="${pelicula.TITTLE}"/> </td>
				<td><a href="/recoveryFilm?cod=${pelicula.COD}">Asociar</a></td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>