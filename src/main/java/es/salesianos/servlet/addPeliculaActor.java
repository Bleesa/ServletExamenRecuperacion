package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.ListService;
import es.salesianos.service.PetService;
import es.salesianos.model.Actor;
import es.salesianos.model.Owner;
import es.salesianos.model.Pelicula;
import es.salesianos.model.Pet;
import es.salesianos.repository.Repository;

public class addPeliculaActor extends HttpServlet {
	
	private ListService servicio = new  ListService();
	private Repository repository = new  Repository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer codActor=Integer.parseInt(req.getParameter("codActor"));
		req.setAttribute("codActor",codActor);
		System.out.println(codActor);

		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listPeliculas.jsp");
		dispatcher.forward(req,resp);
	}
}
