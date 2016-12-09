
<%@page import="com.esi.uclm.procesos.controller.MongoDB" %>
<%@page import="com.esi.uclm.procesos.gestion.Usuario" %>
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
<%
	String user,password,email,rol,id;
	user=request.getParameter("user");
	
	
		 if(user!=null)
			{
			    id=String.valueOf(MongoDB.ultimoid("usuarios_prueba", "usuarios"));
			  	user=request.getParameter("user");
				password=request.getParameter("user");
				email=request.getParameter("email");
				rol="user";
				
			  	
			  	Usuario usuario= new Usuario(id,user,  password,  email,  rol);
			 	MongoDB.inserta_usuario(usuario);
			 	//response.sendRedirect("index.jsp");
			 	out.println("El usuario "+user+" con email: "+email+" ha sido creado correctamente. Ya puede iniciar sesion.");
			 	
			  
			}
	
%>	
		 
</section>
<div  id='marco'>
  <div id="contenedor">
     <div class="vertical">
     <form action="" method="post"> 
      <h2>Autenticacion</h2><br>      
      <div class="contenido">
       	<br>  <input type="hidden" id="id" name="id"><br>
        <label for="Usuario">Usuario: </label><input type="text" name = "user" ><br>
        <label for="Contrasena">Contrasena: </label><input type="password" name = "password"><br>  
        <label for="Email">Email: </label><input type="text" name = "email"><br> 
       <br><br> 	   
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