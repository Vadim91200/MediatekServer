import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.util.*;
public class Signout extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        HttpSession laSession = request.getSession(true);
        laSession.setAttribute("user", null);
        response.sendRedirect("http://localhost:8080/Projet/accueil.html"); 
    }

}
