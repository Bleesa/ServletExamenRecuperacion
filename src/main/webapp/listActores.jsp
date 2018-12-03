<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Owners and their pets</title>
</head>
<body>
	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>
	


	<%
		List<Actor> actors = (List<Actor>) request.getAttribute("listAllActors");
		pageContext.setAttribute("actors", actors);

		List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("listAllPeliculas");
		pageContext.setAttribute("peliculas", peliculas);
		
		List<PeliculasActores> peliculasActores = (List<PeliculasActores>) request.getAttribute("listAllPeliculasByActor");
		pageContext.setAttribute("peliculasActores", peliculasActores);
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<table border="1">
		<thead>
			<tr>
				<td>Cod Actor</td>
				<td>Name</td>
				<td>Surname</td>
				<td>Editar</td>
				<td>Borrar</td>
				<td>Añadir Pelicula</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor1" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor1.lugarNacimiento}" /></td>
					<td><c:out value="${actor1.nomActor}" /></td>
					<td><c:out value="${actor1.apellidos}" /></td>
					<td><a href="/editOwner?codOwner=${actor1.codActor}">EDIT</a>
					</td>
					<td><a href="/confirmDeleteOwner?codOwner=${actor1.codActor}">DELETE</a>
					</td>
					<td><a href="/addPeliculaActor?codActor=${actor1.codActor}">Asignar Pelicula a actor</a>
					</td>
					<td>
					<td>
						<form action="/cargarPeliculasPorActor" method="post">
						<input type="hidden" value="${actor1.codActor}" name="codActor">
						<input type="submit" value="ver listado de PeliculasPorActor">
						</form>
					</td><td>
	    			<c:forEach var="peliculaPorActor" items="${listAllPeliculasByActor}">
	    				<c:out value="${peliculaPorActor.codPelicula} "/>
	    				<c:out value="${peliculaPorActor.codActor} "/>
	    				<c:out value="${peliculaPorActor.nomPersonaje} "/>
	    				<c:out value="${peliculaPorActor.foto} "/>
	    				<br>
	    			</c:forEach>
	    		</td>

				</tr>
			</c:forEach>
				
		</tbody>
	</table>

</body>
</html>