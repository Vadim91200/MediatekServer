import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import mediatek2022.*;
import java.util.*;
public class Processaddingdocument extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        String OPERANDE1 = request.getParameter("name");
    String OPERANDE2 = request.getParameter("Type");
    System.out.println(Integer.parseInt(OPERANDE2));
    Mediatheque.getInstance().ajoutDocument(Integer.parseInt(OPERANDE2), OPERANDE1);
    response.sendRedirect("http://localhost:8080/Projet/MenuLib.jsp");
    }
}
