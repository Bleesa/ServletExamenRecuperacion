package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.Owner;
import es.salesianos.model.Pelicula;
import es.salesianos.model.Pet;
import es.salesianos.model.PeliculasActores;



public class Repository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Owner search(Owner ownerFormulario) {
		Owner ownerInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER WHERE codOwner = ?");
			prepareStatement.setInt(1, ownerFormulario.getCodOwner());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
			
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insert(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ACTOR (NAME,YEAROFBIRTHDATE)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, actor.getName());
			preparedStatement.setInt(2, actor.getYearofbirthday());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
	}
	
	public void insertPelicula(Pelicula pelicula) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO FILM (TITTLE,CODOWNER)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, pelicula.getTITTLE());
			preparedStatement.setInt(2, pelicula.getCODOWNER());


			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
	}
	
	public void insertPeliculasActores(PeliculasActores peliculasActores) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO peliculasActores (codPelicula,codActor,cache,nomPersonaje,foto) VALUES (?,?,?,?,?)");
			preparedStatement.setInt(1, peliculasActores.getCodPelicula());
			preparedStatement.setInt(2, peliculasActores.getCodActor());
			preparedStatement.setInt(3, peliculasActores.getCache());
			preparedStatement.setString(4, peliculasActores.getNomPersonaje());
			preparedStatement.setString(5, peliculasActores.getFoto());


			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
	}

	public void update(Owner ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE OWNER SET name = ?,surname = ? WHERE codOwner = ?");
			preparedStatement.setString(1, ownerFormulario.getName());
			preparedStatement.setString(2, ownerFormulario.getSurname());
			preparedStatement.setInt(3, ownerFormulario.getCodOwner());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void delete(Integer codOwner) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = deletePetsFor(codOwner, conn);
			
			preparedStatement = deleteOwner(codOwner, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	private PreparedStatement deleteOwner(Integer codOwner, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM OWNER WHERE codOwner = ?");
		preparedStatement.setInt(1, codOwner);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deletePetsFor(Integer codOwner, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM PET WHERE codOwner = ?");
		preparedStatement.setInt(1, codOwner);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	public List<Actor> searchAllActors() {
		List<Actor> listOwners = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			/*
			prepareStatement = conn.prepareStatement("
			SELECT * FROM OWNER o, PET p INNER JOIN WHERE o.codOwner = p.codOwner");
			while (resultSet.next()) {
				Owner ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
				Pet pet = new Pet();
				pet.setName(resultSet.getString(4)) 
				pet.setCodOwner(resultSet.getString(5)) 
				ownerInDatabase.getMascotas().add(pet)
				listOwners.add(ownerInDatabase);
			}
			 */
			
			prepareStatement = conn.prepareStatement("SELECT * FROM ACTOR");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Actor actorInDataBase = new Actor();
				
				actorInDataBase.setCod(resultSet.getInt(1));
				actorInDataBase.setName(resultSet.getString(2));
				actorInDataBase.setYearofbirthday(resultSet.getInt(3));
			
				
				listOwners.add(actorInDataBase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOwners;
	}
	
	public List<Pelicula> searchAllPeliculas() {
		List<Pelicula> listPeliculas = new ArrayList<Pelicula>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			/*
			prepareStatement = conn.prepareStatement("
			SELECT * FROM OWNER o, PET p INNER JOIN WHERE o.codOwner = p.codOwner");
			while (resultSet.next()) {
				Owner ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
				Pet pet = new Pet();
				pet.setName(resultSet.getString(4)) 
				pet.setCodOwner(resultSet.getString(5)) 
				ownerInDatabase.getMascotas().add(pet)
				listOwners.add(ownerInDatabase);
			}
			 */
			
			prepareStatement = conn.prepareStatement("SELECT * FROM peliculas");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Pelicula peliculaInDataBase = new Pelicula();
				/*
				peliculaInDataBase.setCodPelicula(resultSet.getInt(1));
				peliculaInDataBase.setTitulo(resultSet.getString(2));
				peliculaInDataBase.setAno(resultSet.getString(3));
				peliculaInDataBase.setTrailer(resultSet.getString(4));
				peliculaInDataBase.setComentario(resultSet.getString(4));
				*/

				
				listPeliculas.add(peliculaInDataBase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listPeliculas;
	}
	
	
	
	public List<PeliculasActores> searchAllPeliculasByActor(int codActor) {
		List<PeliculasActores> listPeliculasActores = new ArrayList<PeliculasActores>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM peliculasActores WHERE codActor = ?");
			prepareStatement.setInt(1, codActor);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				PeliculasActores peliculasActoresEnDatabase= new PeliculasActores();
				peliculasActoresEnDatabase.setCodPelicula(resultSet.getInt(1));
				peliculasActoresEnDatabase.setCodActor(resultSet.getInt(2));
				peliculasActoresEnDatabase.setCache(resultSet.getInt(3));
				peliculasActoresEnDatabase.setNomPersonaje(resultSet.getString(4));
				peliculasActoresEnDatabase.setFoto(resultSet.getString(5));
				

				
				listPeliculasActores.add(peliculasActoresEnDatabase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listPeliculasActores;
	}
	
	public Owner searchByCodOwner(Integer codOwner) {
		Owner ownerInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER WHERE codOwner = ?");
			prepareStatement.setInt(1, codOwner);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public void insertPet(Pet pet) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO PET (petName,codOwner)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, pet.getName());
			preparedStatement.setInt(2, pet.getCodOwner());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
		
	}
	
	public List<Pet> searchAllPets() {
		List<Pet> listPets = new ArrayList<Pet>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM PET WHERE codOwner=?");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Pet petInDatabase = new Pet();
				
				petInDatabase.setName(resultSet.getString(1));
				petInDatabase.setCodOwner(resultSet.getInt(2));
				

				listPets.add(petInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listPets;
	}

	public Owner searchAndDeleteActor(Integer codActor) {
		Owner ownerInDatabase = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM ACTOR WHERE COD = ?");
			prepareStatement.setInt(1, codActor);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}


	public Pet search(Integer codOwner, String petName) {
		Pet petInDataBase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM PET WHERE codOwner = ? AND petName = ? ");
			prepareStatement.setInt(1, codOwner);
			prepareStatement.setString(2, petName);

			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				petInDataBase = new Pet();
				petInDataBase.setName(resultSet.getString(1));
				petInDataBase.setCodOwner(resultSet.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return petInDataBase;		
	}

	public void updatePet(Pet pet , Object antiguoName) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE PET SET petName = ? WHERE codOwner = ? AND petName = ?");
			preparedStatement.setString(1, pet.getName());
			preparedStatement.setInt(2, pet.getCodOwner());
			preparedStatement.setString(3, (String)antiguoName);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}		
	}

	public List<Owner> searchAllByPerson(String nombreAbuscar) {
		List<Owner> listOwners = new ArrayList<Owner>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT O.codOwner,O.name,O.surname FROM OWNER AS O, PET AS P WHERE O.codOwner=P.codOwner AND P.petName = ?");
			prepareStatement.setString(1, nombreAbuscar);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("LLEGA");
				Owner ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
				listOwners.add(ownerInDatabase);
			}
			
			for (Owner owner : listOwners) {

				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM PET where codOwner="+owner.getCodOwner());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Pet pet = new Pet();
					pet.setName(resultSet.getString(1));
					pet.setCodOwner(resultSet.getInt(2));
					owner.getMascotas().add(pet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOwners;
	
	}

}
