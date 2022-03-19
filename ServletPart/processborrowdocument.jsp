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
    ArrayList c = (ArrayList) laSession.getAttribute("choisi");
    List L = Mediatheque.getInstance().tousLesDocumentsDisponibles();
    Mediatheque.getInstance().emprunt((Document) c-1,n); 
      %>
    </body>
</html>