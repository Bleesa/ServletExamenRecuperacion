package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;
import es.salesianos.model.PeliculasActores;

public class OwnerAssembler {

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
	
	public static PeliculasActores assemblePeliculasActoresFrom(HttpServletRequest req) {
		PeliculasActores peliculasActores = new PeliculasActores();
		
		/*private int codPelicula;
		private int codActor;
		private int cache;
		private String nomPersonaje;
		private String foto;*/
		int codPelicula=(Integer.parseInt(req.getParameter("codPelicula")));
		int codActor=(Integer.parseInt(req.getParameter("codActor")));
		int cache=(Integer.parseInt(req.getParameter("cache")));
		String nomPersonaje=req.getParameter("nomPersonaje");
		String foto=req.getParameter("foto");

		peliculasActores.setCodPelicula(codPelicula);;
		peliculasActores.setCodActor(codActor);;
		peliculasActores.setCache(cache);;
		peliculasActores.setNomPersonaje(nomPersonaje);
		peliculasActores.setFoto(foto);;
		
		
		return peliculasActores;
	}
	
	public static Director assembleDirectorFrom(HttpServletRequest req) {
		Director director = new Director();
		String NAME=req.getParameter("NAME");
		director.setName(NAME);
		
		
		return director;
	}
}