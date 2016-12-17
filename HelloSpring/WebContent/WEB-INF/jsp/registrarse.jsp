
<%@page import="com.esi.uclm.procesos.gestion.MongoDB"%>
<%@page import="com.esi.uclm.procesos.gestion.Usuario"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Procesos de Ingieneria del Software</title>

<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/procesos.css" />
</head>



<body>
	<%
		String user, password, email, rol, id;
		user = request.getParameter("user");

		if (user != null) {
			id = String.valueOf(MongoDB.ultimoid("usuarios_prueba", "usuarios"));
			user = request.getParameter("user");
			password = request.getParameter("user");
			email = request.getParameter("email");
			rol = "user";

			Usuario usuario = new Usuario(id, user, password, email, rol);
			MongoDB.inserta_usuario(usuario);
			//response.sendRedirect("index.jsp");
			out.println("El usuario " + user + " con email: " + email
					+ " ha sido creado correctamente. Ya puede iniciar sesion.");

		}
	%>
	<div id="container">
		<h1>Registrarse</h1>

		<div class="vertical col-md-9 col-md-offset-3">
			<form action="" method="post">
				<br>
				<div class="contenido">
					<br> <input type="hidden" id="id" name="id"><br>
					<label for="Usuario">Usuario: </label><input type="text"
						name="user"><br> <label for="Contrasena">Contrasena:
					</label><input type="password" name="password"><br> <label
						for="Email">Email: </label><input type="text" name="email"><br>
					<br> <br>
					<div class="bottom">

						<button type="button" onclick="location.href='/HelloSpring'">Cancelar</button>
						<button type="submit" value="aceptar" name="aceptar">Aceptar</button>
						<br>
					</div>
				</div>
			</form>
		</div>

	</div>
</body>

</html>