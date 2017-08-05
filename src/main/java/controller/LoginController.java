package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AuthenticationService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		
		
		if(action.equals("logout")){
			request.getSession().invalidate();
			response.sendRedirect("/pages/login.jsp");
		}
		
		if((boolean)session.getAttribute("isLoggedOn")){
			response.sendRedirect("./flowcontroller?action=home");
		}
		
		
		if(action.equals("login")){
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			
			if(new AuthenticationService().authenticateUser(username, password)){
				
				session.setAttribute("username", username);
				session.setAttribute("isLoggedOn", true);
				
				
				response.sendRedirect("./flowcontroller?action=home");
				
			}else{
				request.setAttribute("invalidLogin", true);
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
				
			}
			
			
		}
		
		
		
		
		
	}

}
