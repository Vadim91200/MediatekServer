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
    Mediatheque.getInstance().ajoutDocument(OPERANDE1, Object ...(OPERANDE2));
  %>
    </body>
</html>