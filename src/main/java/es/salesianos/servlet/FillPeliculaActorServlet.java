package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.PeliculaActores;
import es.salesianos.model.assembler.PeliculaActoresAssembler;
import es.salesianos.service.OwnerService;
public class FillPeliculaActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OwnerService service = new OwnerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PeliculaActores peliculaActor = PeliculaActoresAssembler.assemblePeliculaActorFrom(req);
		service.insert(peliculaActor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codPelicula = req.getParameter("codPelicula");
		String codActor = req.getParameter("codActor");
		req.setAttribute("codPelicula", codPelicula);
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
