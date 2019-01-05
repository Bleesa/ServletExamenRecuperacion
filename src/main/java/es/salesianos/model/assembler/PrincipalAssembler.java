package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;

public class PrincipalAssembler {

	public static Actor assembleOwnerFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String name=req.getParameter("NAME");
		Integer yearofbirthday=Integer.parseInt(req.getParameter("YEAROFBIRTHDAY"));
		actor.setName(name);
		actor.setYearofbirthday(yearofbirthday);
		return actor;
	}
	
	public static Pelicula assemblePeliculaFrom(HttpServletRequest req) {
		Pelicula pelicula = new Pelicula();
		String titulo=req.getParameter("TITTLE");
		Integer codowner=Integer.parseInt(req.getParameter("CODOWNER"));

		pelicula.setTITTLE(titulo);
		pelicula.setCODOWNER(codowner);
		
		
		return pelicula;
	}
	
	public static Director assembleDirectorFrom(HttpServletRequest req) {
		Director director = new Director();
		String NAME=req.getParameter("NAME");
		director.setName(NAME);
		
		
		return director;
	}
}