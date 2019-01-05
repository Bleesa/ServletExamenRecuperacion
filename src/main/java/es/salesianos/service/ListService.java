package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;
import es.salesianos.repository.Repository;

public class ListService {
	private Repository repository = new Repository();
	
	public List<Actor> listAllActors() {
		return repository.searchActors();
	}
	
	public List<Director> listAllDirectors() {
		return repository.BuscarDirectores();
	}
	
	public List<Film> listAllFilms() {
		return repository.searchAllFilms();
	}

}
