package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;
import es.salesianos.repository.Repository;

public class ListService {
	private Repository repository = new Repository();
	
	public List<Actor> listAllActors() {
		return repository.BuscarActores();
	}
	
	public List<Director> listAllDirectors() {
		return repository.BuscarDirectores();
	}
	
	public List<Pelicula> listAllPeliculas() {
		return repository.searchAllPeliculas();
	}

}
