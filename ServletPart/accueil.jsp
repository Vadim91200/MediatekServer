<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Titre</title>
    </head>
    <body>
	<h1> Bonjour, on est le <%= new java.util.Date() %> </h1>
        <form action="process.jsp" method="post">
  	        <label for="log">Login:</label><br>
            <input type="text" id="log" name="log"><br>
	        <label for="pass">Password:</label><br>
            <input type="password" id="pass" name="pass"><br>
	        <input type="submit" value="Submit">
	    </form>	     
    </body>
</html>