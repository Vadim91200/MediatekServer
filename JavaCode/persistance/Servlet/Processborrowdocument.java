package JavaCode.persistance.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import mediatek2022.*;
import java.util.*;
public class Processborrowdocument extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        HttpSession laSession = request.getSession(true);
        synchronized (laSession) {
            Utilisateur n = (Utilisateur) laSession.getAttribute("user");

            List<Document> L = Mediatheque.getInstance().tousLesDocumentsDisponibles();
            String OPERANDE1 = request.getParameter("Name");
            try {
                Mediatheque.getInstance().emprunt(L.get(Integer.parseInt(OPERANDE1)), n);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;

            String Login = (String) laSession.getAttribute("login");
            String Password = (String) laSession.getAttribute("password");

            Utilisateur TmpUser = Mediatheque.getInstance().getUser(Login, Password);
            laSession.setAttribute("user", TmpUser);
            response.sendRedirect("http://localhost:8080/Projet/MenuSub.jsp");
        }
    }
}
