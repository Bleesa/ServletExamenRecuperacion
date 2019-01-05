package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.FilmsActors;

public class FilmsActorsAssembler {
	public static FilmsActors assemblePeliculaActorFrom(HttpServletRequest req) {
		FilmsActors filmActor = new FilmsActors();
		String codPelicula = req.getParameter("codPelicula");
		String codActor = req.getParameter("codActor");
		String cache = req.getParameter("cache");
		String role = req.getParameter("role");

		filmActor.setCodPelicula(Integer.parseInt(codPelicula));
		filmActor.setCodActor(Integer.parseInt(codActor));
		filmActor.setCache(Integer.parseInt(cache));
		filmActor.setRole(role);

		return filmActor;
	}

}
