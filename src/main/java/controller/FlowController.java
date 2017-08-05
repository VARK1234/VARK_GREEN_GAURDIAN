package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Event;
import beans.ForestAuthority;
import beans.Location;
import database.DBConnection;
import database.DBUtils;
import services.ConcernedForestAuthorityFinder;
import services.DistanceCalculatorService;

/**
 * Servlet implementation class FlowController
 */
@WebServlet("/flowcontroller")
public class FlowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession();



		
		
		
		String action = request.getParameter("action");
		
		if(action==null||action.equals("home")){
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
		
		
		
		
		if(action.equals("raiseconcern")){
			
			String desc = request.getParameter("desc");
			
			String type=request.getParameter("type");
			
			
			
			
			
			
			
			
			String latitude=request.getParameter("lat");
			
			String longitude=request.getParameter("lng");
			
			
			//String latitude="18.597068";
			
			
			//String longitude="73.706932";
			
			
			
			
			Event evt = new Event();
			
			evt.setEventType(type);
			evt.setDescription(desc);
			evt.setLatitude(latitude);
			evt.setLongitude(longitude);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm");    

			Date resultdate = new Date(System.currentTimeMillis());
			
			
			evt.setTime(sdf.format(resultdate));
			ForestAuthority authority=null;
			try{
				authority = new ConcernedForestAuthorityFinder().findForestAuthority(evt);
			}catch(Throwable e){
				e.printStackTrace();
			}
			
			if(authority.getId()==null){
				request.getRequestDispatcher("/pages/refine.jsp").forward(request, response);
				return;
			}
			
			

			evt.setAuthorityId(authority.getId());
			evt.setStatus("Logged");
			if(evt.getEventType().equalsIgnoreCase("threat"))
			{
				evt.setThreatLevel("4");
			}
			else
			{
				evt.setThreatLevel("1");
			}
			
			evt.setId(String.valueOf(DBUtils.insertEvent(DBConnection.getConnection(), evt)));
			
			request.setAttribute("authority",authority);
			
			request.setAttribute("evt",evt);
			
			
			
			
			//response.getWriter().print(desc  + type + authority.getType() + authority.getLocation().getCity());
			
			
			//TODO processing here
			//set attributes here
			//call everything here
			
			request.getRequestDispatcher("/WEB-INF/AckPage.jsp").forward(request, response);
			
			
			
		}
		else if (action.equalsIgnoreCase("refine"))
		{
			try{
				String desc = request.getParameter("desc");
				
				String type=request.getParameter("type");
				
				String authorityType = request.getParameter("authorityType");
				
				
				
				
				
				
				String latitude=request.getParameter("lat");
				
				String longitude=request.getParameter("lng");
				
				
				//String latitude="18.597068";
				
				
				//String longitude="73.706932";
				
				
				
				
				Event evt = new Event();
				
				evt.setEventType(type);
				evt.setDescription(desc);
				evt.setLatitude(latitude);
				evt.setLongitude(longitude);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm");    

				Date resultdate = new Date(System.currentTimeMillis());
				
				
				evt.setTime(sdf.format(resultdate));
				ForestAuthority authority=null;
				Location loc1 = new Location();
				loc1.setLongitude(longitude);
				loc1.setLatitude(latitude);
				
				authority = new ConcernedForestAuthorityFinder().refineAuthorityFinder(evt, authorityType);
				

				evt.setAuthorityId(authority.getId());
				evt.setStatus("Logged");
				if(evt.getEventType().equalsIgnoreCase("threat"))
				{
					evt.setThreatLevel("4");
				}
				else
				{
					evt.setThreatLevel("1");
				}
				
				evt.setId(String.valueOf(DBUtils.insertEvent(DBConnection.getConnection(), evt)));
				
				request.setAttribute("authority",authority);
				
				request.setAttribute("evt",evt);
				
				
				
				
				//response.getWriter().print(desc  + type + authority.getType() + authority.getLocation().getCity());
				
				
				//TODO processing here
				//set attributes here
				//call everything here
				
				request.getRequestDispatcher("/WEB-INF/AckPage.jsp").forward(request, response);
				
				
			}catch(Throwable e){
				e.printStackTrace();
			}	
			
			
			
		}
		
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
		
	}

}
