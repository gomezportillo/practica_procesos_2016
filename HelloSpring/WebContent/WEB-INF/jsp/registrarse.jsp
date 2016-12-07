<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Procesos de Ingieneria del Software </title>
</head>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/procesos.css" />


<body>

<h1> Inicio</h1>

</section>
<div  id='marco'>
  <div id="contenedor">
     <div class="vertical">
     <form action="user_añadido.jsp" method="post"> 
      <h2>Autenticacion</h2><br>      
      <div class="contenido">
        <label for="Usuario">Usuario: </label><input type="text" name = "user" ><br>
        <label for="Contrasena">Contrasena: </label><input type="password" name = "password"><br>  
        <label for="Email">Email: </label><input type="text" name = "email"><br> 
        <label for="Rol">Rol: </label>
        <select name="rol">
				<option value="user" selected>Usuario</option>
		</select><br><br><br> 	   
        <div class="bottom">
        
			<button type="button" onclick="location.href='/HelloSpring'" class="rojo">Cancelar</button>  
			<button type="submit" value="aceptar" name="aceptar" class="verde">Aceptar</button> <br> 
		</div>
      </div>
       </form>  
 	 </div>
</div>

</body>

</html>