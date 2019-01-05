package es.salesianos.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;
import es.salesianos.model.PeliculaActores;
import es.salesianos.model.assembler.PrincipalAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.RangoFechas;

public class OwnerService {
	
	
	private Repository repository = new Repository();
	private RangoFechas converter = new RangoFechas();
	
	
	public Actor assembleOwnerFromRequest(HttpServletRequest req) {
		return PrincipalAssembler.assembleOwnerFrom(req);
	}
	public Pelicula assemblePeliculaFromRequest(HttpServletRequest req) {
		return PrincipalAssembler.assemblePeliculaFrom(req);
	}
	
	public Director assembleDirectorFromRequest(HttpServletRequest req) {
		return PrincipalAssembler.assembleDirectorFrom(req);
	}
	
	public void addOwner(Actor actor) {
		repository.insert(actor);
	}
	
	
	public List<Pelicula> listAllPeliculas() {
		return repository.searchAllPeliculas();
	}
	
	
	public void addPelicula(Pelicula pelicula) {
		repository.insertPelicula(pelicula);
	}
	
	public void addDirector(Director director) {
		repository.insertDirector(director);
	}
	
	
	public List<Actor> filterAllActor(int beginDate, int endDate) {
		return repository.filterAllActor(beginDate, endDate);
	}
	
	public List<Actor> selectAllActor() {
		return repository.selectAllActor();
	}
	
	public void insert(PeliculaActores peliculaActor) {
		repository.insert(peliculaActor);;
	}
	
	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}


}
