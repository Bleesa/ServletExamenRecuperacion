package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;

public class PrincipalAssembler {

	public static Actor assembleOwnerFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String name=req.getParameter("NAME");
		Integer yearofbirthday=Integer.parseInt(req.getParameter("YEAROFBIRTHDAY"));
		actor.setName(name);
		actor.setYearofbirthday(yearofbirthday);
		return actor;
	}
	
	public static Film assemblePeliculaFrom(HttpServletRequest req) {
		Film film = new Film();
		String title=req.getParameter("TITTLE");
		Integer codowner=Integer.parseInt(req.getParameter("CODOWNER"));

		film.setTITTLE(title);
		film.setCODOWNER(codowner);
		
		
		return film;
	}
	
	public static Director assembleDirectorFrom(HttpServletRequest req) {
		Director director = new Director();
		String NAME=req.getParameter("NAME");
		director.setName(NAME);
		
		
		return director;
	}
}