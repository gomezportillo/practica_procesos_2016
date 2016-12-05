<%@page import="com.mongodb.*" %>
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
	
	
	MongoClient mongoClient = new MongoClient("localhost");
	String dbName="procesos";
	String tabla="tareas";
	String rol="";
	DB db=mongoClient.getDB(dbName);
	DBCollection coll= db.getCollection(tabla);
	BasicDBObject doc = new BasicDBObject("nombre",nombre).append("prioridad",prioridad).append("pertenece",pertenece).append("fecha",fecha).append("notas",notas).append("estado",estado);
	coll.insert(doc);
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