<%@page import="com.esi.uclm.procesos.gestion.MongoDB" %>
<%@page import="com.esi.uclm.procesos.gestion.Usuario" %>
<%@page import="java.util.*"%>
<%@page session='true'%> 
 <% HttpSession sesion=request.getSession();
	System.out.println("Último acceso: "+sesion.getId()); 
	System.out.println("La sesión es "+sesion.getAttribute("user"));%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Procesos de Ingieneria del Software </title>
<script type="text/javascript">
function muestra(valor){

var id=document.getElementById("myTable").rows[valor].cells[0].innerHTML;
var user=document.getElementById("myTable").rows[valor].cells[1].innerHTML;
var email=document.getElementById("myTable").rows[valor].cells[2].innerHTML;
var rol=document.getElementById("myTable").rows[valor].cells[3].innerHTML;


document.getElementById("id").value=id;
document.getElementById("user").value=user;
document.getElementById("email").value=email;
document.getElementById("rol").value=rol;


//alert(nombre+prioridad+fecha_limite+estado+pertenece+notas);
}
</script>

<%
	String user,password,email,rol,id;
	String accion=request.getParameter("accion");
	
	if(accion!=null)
	{
			if(accion.equals("borrar"))
			{
				String resultado="No eliminado el usuario";
				id=request.getParameter("id");
				
				if(id!=null){	
					MongoDB.eliminar_usuario(id);
					resultado="SI se ha eliminado el usuario";
				}
			}
	
		  if(accion.equals("anadir"))
			{
			    id=String.valueOf(MongoDB.ultimoid("usuarios_prueba", "usuarios"));
			  	user=request.getParameter("user");
				password=user;
				email=request.getParameter("email");
				rol=request.getParameter("rol");
				
			  	if(user!=null){
			  		Usuario usuario= new Usuario(id,user,  password,  email,  rol);
			 	 	MongoDB.inserta_usuario(usuario);	  	
			  	}
			}
		 
		  	if(accion.equals("modificar"))
		  	{
		  		id=request.getParameter("id");
			  	user=request.getParameter("user");
			 	password=user;
				email=request.getParameter("email");
				rol=request.getParameter("rol");
				
			  	if(user!=null){
			  		Usuario usuario= new Usuario(id,user,  password,  email,  rol);
			 	 	MongoDB.modificar_usuario(usuario);	  	
			  	}
		  	}
	}
	  %>
<script type="text/javascript">
	function borrar(valor)
	{		
		document.getElementById("accion").value="borrar";
	}
	function modificar()
	{
		document.getElementById("accion").value="modificar";
	}
	function anadir()
	{
		document.getElementById("accion").value="anadir";
	}
  </script>
</head>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/procesos.css" />


<body>

<h1> Gestor de usuarios</h1>

</section>
<div  id='marco'>
	<div id="contenedor">
	
	 	<div class="vertical">
	 
			<div class="contenido" title="Administrar tareas">
			
				<%					
						out.println(MongoDB.generar_tabla_users());
				
				 %>
			
			</div>
		</div>
		
		     <div class="vertical">
      <h2>Administrar usuario</h2><br>      
      <div class="contenido">
        <form  method="post">   
        <br>  <input type="hidden" id="id" name="id"><br>
        Usuario:<br>  <input type="text" id="user" name="user"><br>
      
        Email:<br> <input type="text"  value="@gmail.com" id="email" name="email"><br>
        Rol:<br> <input type="text" id="rol" name="rol">
		 <input type="hidden" id="accion" name="accion"><br>
		<div class="bottom">
			<button type="button" onclick=borrar(),this.form.submit()>Borrar</button>         
			<button type="button" onclick=modificar(),this.form.submit()>Modificar</button> 
			<button type="button" onclick=anadir(),this.form.submit()>Añadir</button> <br> 
		<div>
		</form>
      </div>
      
 	 </div>
		
		
	</div>
		<!--  <div id="contenedor">
	
	 	<div class="vertical">
	 
			<div class="contenido" title="Administrar tareas">
			
				<%					
						out.println(MongoDB.generar_tabla_tareas_admin());
				
				 %>
			
			</div>
		</div>
	</div>	 -->
	 	
	 
	 <!--  
	 <label name="busarTarea"></label><br><input type="search" width=20><button type="search" width=20 onclick=" ">Buscar</button><br>
			<textarea name="usuarios" rows="10" cols="40">Aqui se cargaran los usuarios segun lo que se escriba el campo de usuario</textarea>
		 -->	
			

 	
</div>

</body>

</html>