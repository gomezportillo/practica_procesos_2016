<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.esi.uclm.procesos.gestion.MongoDB"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Procesos de Ingeneria del Software</title>
</head>

<script src="https://code.jquery.com/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/procesos.css">

<%
	String user = request.getParameter("user");
	String password, rol;
	String flag = "false";
	HttpSession sesion;
	
	if (user != null) {
		password = request.getParameter("password");
		rol = MongoDB.comprobar_user_pass(user, password);
		if (rol.equals("admin") || rol.equals("user")) {
			flag = "true";
			//out.println("usuario introducido correctamente" +rol);

			user = request.getParameter("user");
			sesion = request.getSession();
			sesion.setAttribute("user", user);
			rol = MongoDB.comprobar_user_pass(user, password);
			sesion.setAttribute("rol", rol);

			//System.out.println("Último acceso: "+sesion.getId()); 
			//System.out.println("La sesión es "+sesion.getAttribute("user"));

			response.sendRedirect("interfaz_user.jsp");
		} else {
			out.println("usuario NO introducido correctamente");
			//response.sendRedirect("index.jsp");
		}
	}
%>

<body>
	<h1>Bienvenido</h1>

	<div id="container">
		<div class="col-md-6">
			<h2>Acceder</h2>
			<br>
			<form method="post" name="form_login" class="col-md-8 col-md-offset-2">

				<label for="login">Usuario: </label> 
				<input type="text" align="right" name="user"> 
				
				<br> 
				
				<label for="contrasena">Contrasena: </label> 
				<input type="password" align="right" name="password">
				
				<br>

				<button style="margin: auto; display: block; width: 40%;"
					type="submit" value="Aceptar" name="aceptar" class="verde">Aceptar</button>
			</form>
		</div>
		<div class="col-md-6 centrado">
			<h2>Registrarse</h2>
			<form action="registrarse.jsp" method="post" class="col-md-8 col-md-offset-2">
			<br>
				<button style="margin: auto; display: block; width: 40%;"
					type="submit" value="Registrarse" name="Registrarse" class="azul">Registarse</button>
			</form>
		</div>
	</div>
</body>

</html>