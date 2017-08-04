package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		
		
		if(action.equals("login")){
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals("admin")&&password.equals("admin")){
				
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("isLoggedOn", true);
				
				
				request.getRequestDispatcher("./flowcontroller").forward(request, response);
				
			}else{
				request.setAttribute("invalidLogin", true);
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
				
			}
			
			
		}
		
		
		
		
		
	}

}
