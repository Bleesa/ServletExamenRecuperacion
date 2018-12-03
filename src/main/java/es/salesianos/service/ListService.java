package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Owner;
import es.salesianos.model.Pelicula;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class ListService {
	private Repository repository = new Repository();
	
	public List<Actor> listAllActors() {
		return repository.searchAllActors();
	}
	
	public List<Pelicula> listAllPeliculas() {
		return repository.searchAllPeliculas();
	}

	public List<Owner> listAllOwnersByPerson(String nombreAbuscar) {
		return repository.searchAllByPerson(nombreAbuscar);
	}
}
