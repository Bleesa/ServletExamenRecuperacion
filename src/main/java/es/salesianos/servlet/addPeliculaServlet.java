package es.salesianos.servlet;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Owner;
import es.salesianos.model.Pelicula;
import es.salesianos.service.OwnerService;

/**
 * Servlet implementation class addOwnerServlet
 */
@WebServlet("/addPeliculaServlet")
public class addPeliculaServlet extends HttpServlet {
private OwnerService service = new OwnerService();
private static final Logger LOGGER = LogManager.getLogger(AddActorServlet.class.getName());

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.debug("llega al addOwnerServlet 1 !!!");
		Pelicula pelicula = service.assemblePeliculaFromRequest(req);
		

		service.addPelicula(pelicula);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(req,resp);
	}
}
