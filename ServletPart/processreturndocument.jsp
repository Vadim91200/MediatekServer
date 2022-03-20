<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>ProcessLogin</title>
    </head>
    <%@ page  import = 'mediatek2022.*'%>
    <%@ page  import = 'java.util.*'%>
    <body>
    <%
    HttpSession laSession = request.getSession(true);
    Utilisateur n = (Utilisateur) laSession.getAttribute("user");

    ArrayList<Document> M = (ArrayList<Document>) n.data()[0];
    String OPERANDE1 = request.getParameter("Name");
    Mediatheque.getInstance().retour(M.get(Integer.parseInt(OPERANDE1)),n);

    String Login = (String) laSession.getAttribute("login");
    String Password = (String) laSession.getAttribute("password");
 
    Utilisateur TmpUser = Mediatheque.getInstance().getUser(Login, Password);
    laSession.setAttribute("user", TmpUser);

    response.sendRedirect("http://localhost:8080/Projet/MenuSub.jsp"); 
      %>
    </body>
</html>