<html>
<head>
<title>Pagina de Inicio</title>
<script type="text/javascript">
 
function Registrar(){
  window.location="nuevousuario.php";
}

</script>

</head>
<body>
<form action="select.php" method="post">
	<table border=n bordercolor="#RRVVAA">
		<tr>	
				<td>Usuario</td>
				<td><input type="text" name="textUsuario" value="admin" size="20" maxlenght="30"></td>	
		</tr>
		<tr>
				<td>Contrasena</td>
				<td><input type="password" name="textPassword" value="admin" size="20" maxlenght="30"></td>	
		</tr>
		<tr>	
				<td><input type="submit" name="btnLogin" value="Login" size="20" maxlenght="20"></td>						
				<td><input type="button" name="btnRegistrar" value="Nuevo Usuario" size="20" maxlenght="20" onclick="Registrar()"></td>	
		</tr>
	</table>
</form>
</body>
</html>