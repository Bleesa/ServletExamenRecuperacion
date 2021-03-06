package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.PrincipalAssembler;
import es.salesianos.service.OwnerService;
import es.salesianos.service.PetService;

/**
 * Servlet implementation class PeliculaActorServlet
 */
public class FilmActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OwnerService service = new OwnerService();
	private PetService service2 = new PetService();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film film = PrincipalAssembler.assemblePeliculaFrom(req);
		service.addFilm(film);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");
		if(null != codString) {
			Film film = new Film();
			int cod = Integer.parseInt(codString);
			film.setCOD(cod);
			service2.searchAndDeletePelicula(cod);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Film> selectAllFilms = service.listAllFilms();
		req.setAttribute("listAllPeliculas", selectAllFilms);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/peliculaactores.jsp");
		dispatcher.forward(req, resp);
	}

}
