
<%@ page import="com.esi.uclm.procesos.controller.MongoDB" %>
<%@ page import="com.esi.uclm.procesos.controller.HelloSpring" %>
<%@ page import="com.esi.uclm.procesos.gestion.Tarea" %>
<%@ page import=" java.util.ArrayList" %>
<%@ page import=" java.util.List" %>
<%@page import="java.util.*"%>
<%@page session='true'%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  


<%@page session='true'%> 
 <% 
	
	%> 
	<script>
function comprobar_y_crear_sesion() {
	<%
		String resultado="No eliminado el usuario";
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		String rol="";
		HttpSession sesion;
		
		if(user!=null && password!=null){	
			//PABLO:AQUI CREO QUE AHORA NO ENTRA NUNCA
			// user=request.getParameter("user");
			sesion=request.getSession();
			sesion.setAttribute("user",user); 
		    rol=MongoDB.comprobar_user_pass(user, password);
			sesion.setAttribute("rol",rol);
			
			System.out.println("Último acceso: "+sesion.getId()); 
		  	System.out.println("La sesión es "+sesion.getAttribute("user"));
		}
		else
		{
			sesion=request.getSession();
			System.out.println("Último acceso: "+sesion.getId()); 
			System.out.println("La sesión es "+sesion.getAttribute("user"));
			System.out.println("El Rol es "+sesion.getAttribute("rol"));
			rol=sesion.getAttribute("rol").toString();
		}
	%>
	  }
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function muestra(valor){

//var x = document.getElementById("myTable").rows[0].cells.length;
//document.getElementById("test").innerHTML=x;  
var id=document.getElementById("myTable").rows[valor].cells[0].innerHTML;
var nombre=document.getElementById("myTable").rows[valor].cells[1].innerHTML;
var prioridad=document.getElementById("myTable").rows[valor].cells[2].innerHTML;
var fecha_limite=document.getElementById("myTable").rows[valor].cells[3].innerHTML;
var estado=document.getElementById("myTable").rows[valor].cells[4].innerHTML;
var pertenece=document.getElementById("myTable").rows[valor].cells[5].innerHTML;
var notas=document.getElementById("myTable").rows[valor].cells[6].innerHTML;



document.getElementById("id").value=id;
document.getElementById("nombre").value=nombre;
document.getElementById("prioridad").value=prioridad;
document.getElementById("fecha_limite").value=fecha_limite;
document.getElementById("estado").value=estado;
document.getElementById("pertenece").value=pertenece;
document.getElementById("notas").value=notas;

//alert(nombre+prioridad+fecha_limite+estado+pertenece+notas);
}
</script>

<script type="text/javascript">
	function guardar_user_sesion(){
		
		document.getElementById("user").value="julio";
	}

</script>
<script type="text/javascript">
<%
String nombre,prioridad,pertenece,fecha,notas,estado,id;

String accion=request.getParameter("accion");
if(accion!=null)
{
	  if(accion.equals("anadir"))
		{
		  	 id=String.valueOf(MongoDB.ultimoid("usuarios_prueba", "tareas"));
		     nombre=request.getParameter("nombre");
			 prioridad=request.getParameter("prioridad");
			 pertenece=request.getParameter("pertenece");
			 fecha=request.getParameter("fecha_limite");
			 notas=request.getParameter("notas");
			 estado=request.getParameter("estado");
			
		  	if(nombre!=null){
		  		Tarea tarea= new Tarea(id,nombre,prioridad,pertenece,fecha,notas,estado);
		 	 	MongoDB.insertar_tarea(tarea);
		  	}
		}
	
  
	  if(accion.equals("modificar"))
		{
		    id=request.getParameter("id");
		    nombre=request.getParameter("nombre");
			prioridad=request.getParameter("prioridad");
			pertenece=request.getParameter("pertenece");
			fecha=request.getParameter("fecha_limite");
			notas=request.getParameter("notas");
			estado=request.getParameter("estado");
			
		  	if(nombre!=null){
		  		Tarea tarea= new Tarea(id,nombre,prioridad,pertenece,fecha,notas,estado);
		 	 	MongoDB.modificar_tarea(tarea);
		  	}
	  
	    }
  
	  if(accion.equals("borrar"))
		{
		    id=request.getParameter("id");		
			
		  	if(id!=null){
		  		//Tarea tarea= new Tarea(nombre,prioridad,pertenece,fecha,notas,estado);
		 	 	MongoDB.eliminar_tarea(id);
		  	}	 
	    }
  
  }
  %>
  </script>
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
					out.println(MongoDB.generar_tabla_tareas_usuario(sesion.getAttribute("user").toString()));
			
			     		if(rol.equals("admin")){
			     			%> 
			    	  		<form action='interfaz_admin.jsp' method='post'>
			    	  		<button type='submit' value='Panel Admin' name='Panel_admin'>Panel Admin</button>
			    	  		</form>
			      			<%	
			      		}
			 %>     		
			</div>
			 
      		 <a href="/HelloSpring">Volver</a>     
		</div>
	  

	<div class="vertical">
	    <h2>Administrar tareas</h2><br>      
		<div class="contenido">
	        <form method="get"> 
	        	<br>  <input type="hidden" id="id" name="id"><br>  
		        Nombre:<br>  <input type="text" id="nombre" name="nombre"><br>
		        Prioridad:<br>  <input type="text" id="prioridad" name="prioridad" ><br>
		        Fecha Limite:<br>  <input type="text"  id="fecha_limite" name="fecha_limite"><br>
		        Estado:<br>  <input type="text" id="estado" name="estado"><br>
		        Pertenece:<br>  <input type="text" id="pertenece" name="pertenece"><br>
		        Notas:<br>  <input type="text" id="notas" name="notas"><br>		        
				 <input type="hidden" id="accion" name="accion"><br>
		        
				<div class="bottom">
					<button type="button" name ="borrar" value = "borrar" onclick=comprobar_y_crear_sesion(),borrar(),this.form.submit()>Borrar</button>         
					<button type="button" name ="modificar" value = "modificar" onclick=comprobar_y_crear_sesion(),modificar(),this.form.submit()>Modificar</button>  
					        
					<button type="button" name ="anadir" value = "anadir" onclick=comprobar_y_crear_sesion(),anadir(),this.form.submit()>Añadir</button>    
					 
				<div>
			</form>
		</div>
	</div>
</div>
</div>
 

 
</body>

</html>