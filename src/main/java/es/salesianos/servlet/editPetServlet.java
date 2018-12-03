package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.model.Pet;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.service.OwnerService;
import es.salesianos.service.PetService;

public class editPetServlet extends HttpServlet{
	private PetService service = new PetService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		String PetName = req.getParameter("PetName");
		Pet PetInDataBase = service.search(Integer.parseInt(codOwner),PetName);
		req.setAttribute("pet", PetInDataBase);
		req.setAttribute("name", PetInDataBase.getName());

		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editPet.jsp");
		dispatcher.forward(req,resp);
	}
}
