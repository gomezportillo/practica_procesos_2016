<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String nombre = request.getParameter("nombre");

	nombre = nombre.toUpperCase();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Spring - Welcome !</title>
</head>
<body>
	<h2 style="text-align: center;">${message}<%= nombre %> !</h2>
	<br /> <br />
	<div style="text-align: center;"><a href="/HelloSpring"">Volver</a> </div>
</body>
</html>