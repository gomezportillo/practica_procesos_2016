<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Procesos de Ingieneria del Software </title>
</head>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/procesos.css" />


<body>

<h1> Gestor de usuarios</h1>

</section>
<div  id='marco'>
  <div id="contenedor">
	
	 <div class="vertical">
	 <h2>Buscar usuario existente</h2><br>
		<div class="contenido">
			Buscar usuario: <br><input type="search" width=20><br><br>
			<textarea name="usuarios" rows="10" cols="40">Aquí se cargaran los usuarios según lo que se escriba el campo de usuario</textarea>
		</div>
	 </div>
     <div class="vertical">
      <h2>Administrar usuario</h2><br>      
      <div class="contenido">
        Usuario:<br>  <input type="text"><br>
        Contraseña:<br>  <input type="password"><br><br>
        Email:<br> <input type="text"  value="@gmail.com"><br>
        Rol:<br>  <select name="rol">
					<option>Administrador</option>
					<option selected>Usuario</option>
				 </select><br><br><br> 	
		<div class="bottom">
			<button type="button" onclick="location.href='index.html'">Borrar</button>         
			<button type="button" onclick="location.href='registrarse.html'">Modificar</button>  
			<!--<button type="button" onclick="location.href='index.html'">Denegar</button> -->        
			<button type="button" onclick="location.href='registrarse.html'">Añadir</button>   
		<div>
      </div>
 	 </div>
</div>

</body>

</html>