<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Spring !</title>
</head>
<body>
	<br>
	<div style="text-align: center;">
		<table border=1>
		<tr>
			<td>Usuario</td>
			<td><input type="text" name="usuario" /></td>
		</tr>
		<tr>
			<td>Contrase�a</td>
			<td><input type="text" name="contrase�a" /></td>
		</tr>
		<tr>
			
			<td>
				<form action="bienvenido.jsp" method="post">
				<input type="submit" value="Aceptar" />
				</form> 
			</td>
		</tr>
		
		</table>
		
		
	</div>
</body>
</html>