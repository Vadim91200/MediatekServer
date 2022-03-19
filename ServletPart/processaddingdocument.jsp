<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>ProcessLogin</title>
    </head>
    <%@ page  import = 'mediatek2022.*'%>
    <body>
    <%
    String OPERANDE1 = request.getParameter("name");
    String OPERANDE2 = request.getParameter("Type");
    System.out.println(Integer.parseInt(OPERANDE2));
    Mediatheque.getInstance().ajoutDocument(Integer.parseInt(OPERANDE2), OPERANDE1);
    response.sendRedirect("http://localhost:8080/Projet/MenuLib.jsp");
  %>
    </body>
</html>