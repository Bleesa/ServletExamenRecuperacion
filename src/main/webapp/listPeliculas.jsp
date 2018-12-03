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
	<form action="cargarListadoPeliculas" method="post">
		<input type="hidden" value="<%= request.getAttribute("codActor") %>" name="codActor">
		<input type="hidden" value="<%= request.getAttribute("codActor") %>" name="codActor">
		<input type="submit" value="ver listado">
	</form>


	<%
		List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("listAllPeliculas");
		pageContext.setAttribute("peliculas", peliculas);
/*
		Integer codActor = (Integer) request.getAttribute("codActor");
		pageContext.setAttribute("codActor", request.getAttribute("codActor"));
		*/
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
				<td>Cod Pelicula</td>
				<td>Nombre Película</td>
				<td>Formulario</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pelicula" items="${listAllPeliculas}">
				<tr>
					<td><c:out value="${pelicula.codPelicula}" /></td>
					<td><c:out value="${pelicula.titulo}" /></td>
					<td>
					<form action="/addFilmToActor" method="post">
					<input type="hidden" value="<%= request.getAttribute("codActor") %>" name="codActor">
					<input type="hidden" value="${pelicula.codPelicula}" name="codPelicula">
					<input value="" type="text" placeholder="cache" name="cache">
					<input value="" type="text" placeholder="nomPersonaje" name="nomPersonaje">
					<input value="" type="text" placeholder="foto" name="foto">
					<input type="submit" value="Añadir">
					</form></td>


					<%-- <td>
	    			<c:forEach var="pet" items="${owner1.mascotas}">
	    				<c:out value="${pet.name} "/>
	    				<a href="/deletePet?codOwner=${owner1.codOwner}&PetName=${pet.name}">BORRAR MASCOTA</a>
	    				<a href="/editPet?codOwner=${owner1.codOwner}&PetName=${pet.name}">EDITAR MASCOTA</a>
	    				<br>
	    			</c:forEach>
	    		</td> --%>

				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>