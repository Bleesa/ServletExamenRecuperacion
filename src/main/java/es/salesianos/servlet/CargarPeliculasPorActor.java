package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.PeliculasActores;
import es.salesianos.service.OwnerService;

public class CargarPeliculasPorActor extends HttpServlet{
	
	private OwnerService servicio = new OwnerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PeliculasActores> listAllPeliculasByActor = servicio.listAllPeliculasPorActor(Integer.parseInt((req.getParameter("codActor"))));
		req.setAttribute("listAllPeliculasByActor", listAllPeliculasByActor);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listActores.jsp");
		dispatcher.forward(req, resp);
	}
	

}
