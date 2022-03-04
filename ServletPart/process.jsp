<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affiche</title>
    </head>
    <%@ page  import = 'mediatek2022.*'%>
    <body>
	<h1> Bonjour, on est le <%= new java.util.Date() %> </h1>
    <%
    String OPERANDE1 = request.getParameter("log");
    String OPERANDE2 = request.getParameter("pass");
    Utilisateur Michel = Mediatheque.getInstance().getUser(OPERANDE1, OPERANDE2);
    out.println("Je crois que ça marche");

    out.println(Michel.name());
  %>
    </body>
</html>