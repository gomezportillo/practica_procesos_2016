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
        Usuario:  <br><input type="text" name = "user" ><br>
        Contrasena: <br><input type="password" name = "password"><br>  
        Email: <br><input type="text" name = "email"><br> 
        Rol: <br>  <select name="rol">
					<option value="user" selected>Usuario</option>
				 </select><br><br><br> 	   
        <div class="bottom">
        
			<button type="button" onclick="location.href='/HelloSpring'">Cancelar</button>  
			<button type="submit" value="aceptar" name="aceptar">Aceptar</button> <br> 
		</div>
      </div>
       </form>  
 	 </div>
</div>

</body>

</html>