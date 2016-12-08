
<%@ page import="com.esi.uclm.procesos.controller.MongoDB" %>
<%@ page import="com.esi.uclm.procesos.controller.HelloSpring" %>
<%@ page import="com.esi.uclm.procesos.gestion.Tarea" %>
<%@ page import=" java.util.ArrayList" %>
<%@ page import=" java.util.List" %>
<%@page import="java.util.*"%>
<%@page session='true'%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  


<%
	//BASURA_MongoDB.eliminar_usuario();
	//BASURA_MongoDB.modificar_usuario();
	
	String user = request.getParameter("user");	
	String password = request.getParameter("password");
	
	String rol=MongoDB.comprobar_user_pass(user, password);
 	//System.out.println(rol);
	
	//MongoDB.generar_list_tareas();
   // System.out.println(tarea);
	
	
%>
 <% HttpSession sesion=request.getSession();
 	sesion.setAttribute("user",user); 
	System.out.println("Último acceso: "+sesion.getId()); 
	System.out.println("La sesión es "+sesion.getAttribute("user"));
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function muestra(valor){

//var x = document.getElementById("myTable").rows[0].cells.length;
//document.getElementById("test").innerHTML=x;  
var nombre=document.getElementById("myTable").rows[valor].cells[0].innerHTML;
var prioridad=document.getElementById("myTable").rows[valor].cells[1].innerHTML;
var fecha_limite=document.getElementById("myTable").rows[valor].cells[2].innerHTML;
var estado=document.getElementById("myTable").rows[valor].cells[3].innerHTML;
var pertenece=document.getElementById("myTable").rows[valor].cells[4].innerHTML;
var notas=document.getElementById("myTable").rows[valor].cells[5].innerHTML;




document.getElementById("nombre").value=nombre;
document.getElementById("prioridad").value=prioridad;
document.getElementById("fecha_limite").value=fecha_limite;
document.getElementById("estado").value=estado;
document.getElementById("pertenece").value=pertenece;
document.getElementById("notas").value=notas;

//alert(nombre+prioridad+fecha_limite+estado+pertenece+notas);
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tareas</title>

</head>


<link rel="stylesheet" type="text/css" href="css/procesos.css" />
<body>
	<h2 style="text-align: center;">Usuario:  <%= sesion.getAttribute("user") %> !</h2>	
	


<h1> Inicio</h1>


<div  id='marco'>
	<div id="contenedor">
		<div class="vertical">
		     <h2>Usuario</h2><br>      
		     <div class="contenido" id="cont">
		      
			<%					
					out.println(MongoDB.generar_tabla_tareas_usuario(user));
			
			     		if(rol.equals("admin")){
			    	  		out.println("<form action='interfaz_admin.jsp' method='post'><button type='submit' value='Panel Admin' name='Panel_admin'/>Panel Admin</button> <br> </form> ");
			      		}
			 %>     		
			</div>
		</div>
	</div>

	<div class="vertical">
	    <h2>Administrar usuario</h2><br>      
		<div class="contenido">
	        <form action="user_añadido.jsp" method="post">   
		        Nombre:<br>  <input type="text" id="nombre" name="nombre"><br>
		        Prioridad:<br>  <input type="text" id="prioridad" name="prioridad" ><br>
		        Fecha Limite:<br>  <input type="text"  id="fecha_limite" name="fecha_limite"><br>
		        Estado:<br>  <input type="text" id="estado" name="estado"><br>
		        Pertenece:<br>  <input type="text" id="pertenece" name="pertenece"><br>
		        Notas:<br>  <input type="text" id="notas" name="notas"><br>
		        
		        
				<div class="bottom">
					<button type="button" onclick="location.href='index.html'">Borrar</button>         
					<button type="button" onclick="location.href='registrarse.html'">Modificar</button>  
					<!--<button type="button" onclick="location.href='index.html'">Denegar</button> -->        
					<!--<button type="button" onclick="location.href='registrarse.html'">Añadir</button>  -->   
					<!--<button type="submit" value="Añadir" name="Añadir"/>Añadir</button> <br>--> 
				<div>
			</form>
		</div>
	</div>

</div>
 
<!--  

		<form action="tarea.jsp" method="post" target="_blank">
			<button type="submit" value="anadir" name="anadir" class="verde">Añadir</button><br>
		</form>
		<button type="button" >Modificar</button><br>	
    	<button type="submit"  value="borrar" name="borrar" >Eliminar</button>	
    	<a href="/HelloSpring">Volver</a>     
      </div>
	</div>
</div>
 </div>
-->
 
</body>
</body>
</html>