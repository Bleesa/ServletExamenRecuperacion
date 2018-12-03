package es.salesianos.model;

public class PeliculasActores {
	
	private int codPelicula;
	private int codActor;
	private int cache;
	private String nomPersonaje;
	private String foto;
	
	public int getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}
	public int getCodActor() {
		return codActor;
	}
	public void setCodActor(int codActor) {
		this.codActor = codActor;
	}
	public int getCache() {
		return cache;
	}
	public void setCache(int cache) {
		this.cache = cache;
	}
	public String getNomPersonaje() {
		return nomPersonaje;
	}
	public void setNomPersonaje(String nomPersonaje) {
		this.nomPersonaje = nomPersonaje;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
