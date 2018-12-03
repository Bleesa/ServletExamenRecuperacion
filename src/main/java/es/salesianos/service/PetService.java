package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Owner;
import es.salesianos.model.Pet;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class PetService {

	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	
	
	public Pet assemblePetFromRequest(HttpServletRequest req) {
		return PetAssembler.assemblePetFrom(req);
	}
	
	public void addPet(Pet pet) {
		repository.insertPet(pet);
	}
	
	public void searchAndDeleteActor(Integer codActor) {
		repository.searchAndDeleteActor(codActor);
	}
	
	public void searchAndDeleteDirector(Integer codDirector) {
		repository.searchAndDeleteDirector(codDirector);
	}
	
	public void searchAndDeletePelicula(Integer codPelicula) {
		repository.searchAndDeleteDirector(codPelicula);
	}


	public Pet search(Integer codOwner, String petName) {
		Pet PetInDataBase=repository.search(codOwner,petName);
		return PetInDataBase;
	}

	public void update(Pet pet,Object antiguoName) {
		repository.updatePet(pet ,  antiguoName);
	}
}
