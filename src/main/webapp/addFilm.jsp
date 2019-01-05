<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nueva Film</title>
</head>
<body>
<form action="cargarListadoPeliculas" method="post">
		<input type="submit" value="ver listado">
</form>

	<%
		List<Film> films = (List<Film>) request.getAttribute("listAllPeliculas");
			pageContext.setAttribute("peliculas", films);
	%>

	<form action="AddPelicula" method="post">
		<span>Title:</span><input type="text" name="TITTLE">
		<span>Cod Director</span><input type="number" name="CODOWNER">
		<input type="submit">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>TITLE</td>
				<td>CODFilm</td>
				<td>Delete Film</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pelicula1" items="${listAllPeliculas}">
				<tr>
					<td><c:out value="${pelicula1.TITTLE}" /></td>
					<td><c:out value="${pelicula1.CODOWNER}" /></td>
					<td><a href="/deletePelicula?codPelicula=${pelicula1.COD}">DELETE</a>
					</td>
				</tr>
			</c:forEach>
				
		</tbody>
	</table>
</body>
</html>