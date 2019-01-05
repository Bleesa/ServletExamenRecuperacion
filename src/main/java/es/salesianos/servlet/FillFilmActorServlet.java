package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.FilmsActors;
import es.salesianos.model.assembler.FilmsActorsAssembler;
import es.salesianos.service.OwnerService;
public class FillFilmActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OwnerService service = new OwnerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmsActors filmActor = FilmsActorsAssembler.assemblePeliculaActorFrom(req);
		service.insert(filmActor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codFilm = req.getParameter("codPelicula");
		String codActor = req.getParameter("codActor");
		req.setAttribute("codPelicula", codFilm);
		req.setAttribute("codActor", codActor);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FillPeliculaActor.jsp");
		dispatcher.forward(req, resp);
	}
}
