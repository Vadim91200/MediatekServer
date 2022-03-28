package JavaCode.persistance.Servlet;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Processsignout extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        HttpSession laSession = request.getSession(true);
        synchronized (laSession) {
            laSession.setAttribute("user", null);
            response.sendRedirect("http://localhost:8080/Projet/accueil.html");
        }
    }
}
