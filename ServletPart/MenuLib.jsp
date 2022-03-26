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
    <%
    HttpSession leSession = request.getSession(true);
    synchronized (laSession) {
      Utilisateur u = (Utilisateur) leSession.getAttribute("user");
      if(u!=null){
      %>
<main class="form-signin">
  <form action="AddDocument" method="post">
    <h1 class="h3 mb-3 fw-normal">Add a document</h1>
    
      
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingName" name="name" placeholder="Naee">
      <label for="floatingInput">Name of the document</label>
    </div>
    <div class="form-floating">
      <select class="form-select" name ="Type" aria-label="Default select example">
        <option selected> Select the type of the document</option>
        <option value="1">Book</option>
        <option value="2">DVD</option>
        <option value="3">CD</option>
      </select>
    </div>
    <button id="sub"class="w-100 btn btn-lg btn-primary" type="submit" style="margin-top: 10px; margin-bottom: 20px;">Add document</button>
  </form>
    <button class="w-100 btn btn-lg btn-primary" onclick="window.location.href='Logout'" >Sign Out</button>
  
</main>
<%
}else {
  response.sendRedirect("http://localhost:8080/Projet/accueil.html");
}
    }
%>


    
  </body>
</html>
