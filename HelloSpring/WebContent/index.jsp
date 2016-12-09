<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.esi.uclm.procesos.controller.MongoDB" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Procesos de Ingieneria del Software </title>
</head>


  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/procesos.css" />


<%

String user= request.getParameter("user");
String password,rol;
String flag="false";
HttpSession sesion;
if(user!=null)
{
     password=request.getParameter("password");
	rol=MongoDB.comprobar_user_pass(user, password);
	if(rol.equals("admin") || rol.equals("user") ){
		flag="true";
		out.println("usuario introducido correctamente" +rol);
			
			// user=request.getParameter("user");
			sesion=request.getSession();
			sesion.setAttribute("user",user); 
		    rol=MongoDB.comprobar_user_pass(user, password);
			sesion.setAttribute("rol",rol);
			
			System.out.println("Último acceso: "+sesion.getId()); 
		  	System.out.println("La sesión es "+sesion.getAttribute("user"));
		
		response.sendRedirect("interfaz_user.jsp");
	}
	else
	{
		out.println("usuario NO introducido correctamente");
		//response.sendRedirect("index.jsp");
	}
	
  	
}
%>





<body>
<h1>Inicio</h1>

</section>

	<div id="contenedor">
	    <div class="vertical">
			<h2>Autenticacion</h2><br>      
			<div class="contenido">
			<form method="post" name="form_login">
	      
				<label for="login">Usuario: </label>			<input type="text" align="right" name="user"> <br>
				<label for="contrasena">Contrasena: </label> <input type="password" align="right" name="password"><br>  
			
				<button type="submit" value="Aceptar" name="aceptar"  class="verde">Aceptar</button>
			</form>
			<form action="registrarse.jsp" method="post">
				<button type="submit" value="Registrarse" name = "Registrarse" class="azul">Registarse</button> 
			</form>
    
	      </div>
	 	 </div>
	</div>
</body>

</html>