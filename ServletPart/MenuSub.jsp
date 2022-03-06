<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>ProcessLogin</title>
    </head>
    <%@ page  import = 'mediatek2022.*'%>
    <body>
    <%
    String OPERANDE1 = request.getParameter("login");
    String OPERANDE2 = request.getParameter("password");
    Utilisateur Michel = Mediatheque.getInstance().getUser(OPERANDE1, OPERANDE2);
    if (Michel == null){
        out.println("BAD USER");
        System.out.println("BAD USER");
        out.println(OPERANDE1);
        out.println(OPERANDE2);
        response.sendRedirect("http://localhost:8080/Projet/accueil.html");
    }else{
        if {Michel.isBibliothecaire()}
        out.println(Michel.name());
    }
  %>
    </body>
</html>