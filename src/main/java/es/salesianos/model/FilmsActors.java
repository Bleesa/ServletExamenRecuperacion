package es.salesianos.model;

public class FilmsActors {
	private int cache;
	private String role;
	private int codFilm;
	private int codActor;

	public int getCache() {
		return cache;
	}
	public void setCache(int cache) {
		this.cache = cache;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCodPelicula() {
		return codFilm;
	}
	public void setCodPelicula(int codPelicula) {
		this.codFilm = codPelicula;
	}
	public int getCodActor() {
		return codActor;
	}
	public void setCodActor(int codActor) {
		this.codActor = codActor;
	}

}
