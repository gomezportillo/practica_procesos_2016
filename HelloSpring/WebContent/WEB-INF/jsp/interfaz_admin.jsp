<%@page import="com.esi.uclm.procesos.controller.MongoDB" %>
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
			Buscar usuario: <br><input type="search" width=20><button type="search" width=20 onclick=" ">Buscar</button><br>
	<%
	out.println(MongoDB.generar_tabla_users("usuarios_prueba", "usuarios"));
	
	
	%>
	<br>
			<textarea name="usuarios" rows="10" cols="40">Aqui se cargaran los usuarios segun lo que se escriba el campo de usuario</textarea>
		</div>
	 </div>
     <div class="vertical">
      <h2>Administrar usuario</h2><br>      
      <div class="contenido">
        <form action="user_añadido.jsp" method="post">   
        Usuario:<br>  <input type="text" name="user"><br>
        Contraseña:<br>  <input type="password" name="password"><br><br>
        Email:<br> <input type="text"  value="@gmail.com" name="email"><br>
        Rol:<br>  <select name="rol">
					<option value="admin">Administrador</option>
					<option value="user" selected>Usuario</option>
				 </select><br><br><br> 	
		
		<div class="bottom">
			<button type="button" onclick="location.href='index.html'">Borrar</button>         
			<button type="button" onclick="location.href='registrarse.html'">Modificar</button>  
			<!--<button type="button" onclick="location.href='index.html'">Denegar</button> -->        
			<!--<button type="button" onclick="location.href='registrarse.html'">Añadir</button>  -->   
			<button type="submit" value="Añadir" name="Añadir"/>Añadir</button> <br> 
		<div>
		</form>
      </div>
 	 </div>
</div>

</body>

</html>