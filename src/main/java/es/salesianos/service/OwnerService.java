package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Owner;
import es.salesianos.model.Pelicula;
import es.salesianos.model.assembler.OwnerAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.model.PeliculasActores;
import es.salesianos.utils.DateConverter;

public class OwnerService {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	
	
	public Actor assembleOwnerFromRequest(HttpServletRequest req) {
		return OwnerAssembler.assembleOwnerFrom(req);
	}
	public Pelicula assemblePeliculaFromRequest(HttpServletRequest req) {
		return OwnerAssembler.assemblePeliculaFrom(req);
	}
	
	public Director assembleDirectorFromRequest(HttpServletRequest req) {
		return OwnerAssembler.assembleDirectorFrom(req);
	}
	
	public void addOwner(Actor actor) {
		repository.insert(actor);
	}
	
	
	
	public List<Pelicula> listAllPeliculas() {
		return repository.searchAllPeliculas();
	}
	
	public List<PeliculasActores> listAllPeliculasPorActor(int codActor) {
		return repository.searchAllPeliculasByActor(codActor);
	}
	
	public void addPelicula(Pelicula pelicula) {
		repository.insertPelicula(pelicula);
	}
	
	public void addDirector(Director director) {
		repository.insertDirector(director);
	}
	
	public void addPeliculasActores(PeliculasActores peliculasActores) {
		repository.insertPeliculasActores(peliculasActores);
	}

	public void insertOrUpdate(Actor actor) {
		//Owner userInDatabase = repository.search(ownerFormulario);
		if(null == actor){
			//repository.insert(ownerFormulario);
		}else{
			//repository.update(ownerFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public Owner search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}


}
