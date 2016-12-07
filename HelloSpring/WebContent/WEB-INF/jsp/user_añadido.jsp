
<%@page import="com.esi.uclm.procesos.controller.MongoDB" %>
<%@page import="com.esi.uclm.procesos.controller.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String user = request.getParameter("user");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String rol = request.getParameter("rol");
	
	Usuario usuario= new Usuario(user, password, email, rol);
	MongoDB.inserta_usuario(usuario);
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarea añadida</title>
</head>
<body>
	<h2 style="text-align: center;">${message} !</h2>
	<h1><%= user %></h1><br>
	<h1><%= password %></h1><br>
	<h1><%= email%></h1><br>
	<h1><%= rol%></h1><br>

	
	<br /> <br />
	<div style="text-align: center;"><a href="/HelloSpring/interfaz_admin">Volver</a> </div>
</body>
</html>