package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class PetService {

	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	
	
	
	
	public void searchAndDeleteActor(Integer codActor) {
		repository.searchAndDeleteActor(codActor);
	}
	
	public void searchAndDeleteDirector(Integer codDirector) {
		repository.searchAndDeleteDirector(codDirector);
	}
	
	public void searchAndDeletePelicula(Integer codPelicula) {
		repository.searchAndDeletePelicula(codPelicula);
	}



}
