<%@page import="com.mongodb.*" %>
<%@page import="com.esi.uclm.procesos.controller.MongoDB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String nombre = request.getParameter("nombre");
	String prioridad = request.getParameter("prioridad");
	String pertenece = request.getParameter("pertenece");
	String fecha= request.getParameter("fecha");
	String notas= request.getParameter("notas");
	
////////////////////REVISAR ESTA PARTE DEL ESTADO, PARA COGER EL VALOR CORRECTO///////////////
	String estado= request.getParameter("estado");	
	if(estado==null)
	{
		estado="vacio";
	}
	MongoDB.insertar_tarea(nombre, prioridad, pertenece, fecha, notas, estado);
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarea añadida</title>
</head>
<body>
	<h2 style="text-align: center;">${message} !</h2>
	<h1><%= prioridad %></h1><br>
	<h1><%= pertenece %></h1><br>
	<h1><%= fecha%></h1><br>
	<h1><%= notas%></h1><br>
	<h1><%= estado%></h1><br>
	
	
	<br /> <br />
	<div style="text-align: center;"><a href="/HelloSpring"">Volver</a> </div>
</body>
</html>