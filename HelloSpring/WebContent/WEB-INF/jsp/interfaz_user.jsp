
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
</body>
</body>
</html>