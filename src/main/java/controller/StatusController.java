package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Event;
import services.FetchUserData;
import services.UpdateEventStatusService;

/**
 * Servlet implementation class StatusController
 */
@WebServlet("/statuscontroller")
public class StatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		
		
		
		if(action.equals("ACKNOWLEDGE")){
			new UpdateEventStatusService().updateStatus(request.getParameter("eventid"), "ACKNOWLEDGED");
		}
		
		if(action.equals("DECLINE")){
			new UpdateEventStatusService().updateStatus(request.getParameter("eventid"), "DECLINED");
		}
		
		if(action.equals("COMPLETE")){
			new UpdateEventStatusService().updateStatus(request.getParameter("eventid"), "COMPLETED");
		}
		
		
		List<Event> list = new FetchUserData().getEventData(request.getSession().getAttribute("username").toString());
		
		
		
		request.getSession().setAttribute("events",list );
		
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}

}
