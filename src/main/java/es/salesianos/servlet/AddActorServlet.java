package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.service.OwnerService;

/**
 * Servlet implementation class addOwnerServlet
 */
public class AddActorServlet extends HttpServlet {
private OwnerService service = new OwnerService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("beginDate");
		if (parameter != null) {
			int beginDate = Integer.parseInt(req.getParameter("beginDate"));
			int endDate = Integer.parseInt(req.getParameter("endDate"));
			List<Actor> listAllActor = service.filterAllActor(beginDate, endDate);
			req.setAttribute("listAllActors", listAllActor);
		} else {
			Actor actor = service.assembleOwnerFromRequest(req);

			service.addOwner(actor);
			List<Actor> listAllActors = service.selectAllActor();
			req.setAttribute("listAllActors", listAllActors);
		}
		
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addActor.jsp");
		dispatcher.forward(req,resp);
	}
}
