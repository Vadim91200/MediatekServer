import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import mediatek2022.*;
import java.util.*;
public class Processlogin extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String OPERANDE1 = request.getParameter("login");
        String OPERANDE2 = request.getParameter("password");
        Utilisateur Michel = Mediatheque.getInstance().getUser(OPERANDE1, OPERANDE2);
        if (Michel == null) {
            response.sendRedirect("http://localhost:8080/Projet/accueil.html");
        } else {
            synchronized (Michel) {
                HttpSession laSession = request.getSession(true);
                laSession.setAttribute("user", Michel);
                laSession.setAttribute("login", OPERANDE1);
                laSession.setAttribute("password", OPERANDE2);
                if (Michel.isBibliothecaire()) {
                    response.sendRedirect("http://localhost:8080/Projet/MenuLib.jsp");
                } else {
                    response.sendRedirect("http://localhost:8080/Projet/MenuSub.jsp");
                }
            }
        }
    }
}
