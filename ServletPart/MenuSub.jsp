<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Login page</title>
   
    <!-- Bootstrap core CSS -->
<link href="./assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <%@ page  import = 'mediatek2022.*'%>
    <%@ page  import = 'java.util.*'%>
<main class="form-signin">
  <form action="processborrowdocument.jsp" method="post">
    <%
        List L = Mediatheque.getInstance().tousLesDocumentsDisponibles();
        int c;
      %>
    <h1 class="h3 mb-6 fw-normal">Borrow a document</h1>
    <div class="form-floating">
      <select class="form-select" name ="Name" aria-label="Default select example">
        <option selected> Select the name of the document</option>
        <%
        for(c=0; c< L.size(); c++){
        %>
            <option value=<%=c%>> <%= L.get(c).toString() %> </option> 
        <%
        }
        HttpSession laSession = request.getSession(true);
        laSession.setAttribute("choisi", c);
        %>
      </select>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Borrow</button>
  </form>
  <form action="" method="post"></form>
    <h1 class="h3 mb-6 fw-normal">return a document</h1>
    <div class="form-floating">
      <select class="form-select" name ="Name" aria-label="Default select example">
        <option selected> Select the name of the document</option>
        <%
        HttpSession leSession = request.getSession(true);
        Utilisateur u = (Utilisateur) leSession.getAttribute("user");
        ArrayList<String> M = (ArrayList<String>) u.data()[0];
        for(int i=0; i< M.size(); i++){
            %>
            <option value=<%=i%>> <%= M.get(i).toString() %> </option> 
            <%
        }
        %>
      </select>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Return</button>
  </form>
</main>


    
  </body>
</html>
