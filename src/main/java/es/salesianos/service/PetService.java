package es.salesianos.service;

import es.salesianos.repository.Repository;
import es.salesianos.utils.RangoFechas;

public class PetService {

	private Repository repository = new Repository();
	private RangoFechas conver = new RangoFechas();
	
	
	
	
	public void searchAndDeleteActor(Integer codActor) {
		repository.searchAndDeleteActor(codActor);
	}
	
	public void searchAndDeleteDirector(Integer codDirector) {
		repository.searchAndDeleteDirector(codDirector);
	}
	
	public void searchAndDeletePelicula(Integer codFilm) {
		repository.searchAndDeletePelicula(codFilm);
	}


}
