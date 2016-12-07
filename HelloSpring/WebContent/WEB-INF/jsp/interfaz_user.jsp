
<%@ page import="com.esi.uclm.procesos.controller.MongoDB" %>
<%@ page import="com.esi.uclm.procesos.controller.HelloSpring" %>
<%@ page import=" java.util.ArrayList" %>
<%@ page import=" java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%
	String user = request.getParameter("user");
	String password = request.getParameter("password");
	
	String rol=MongoDB.comprobar_user_pass(user, password);
	System.out.println(rol);
	List lista_tareas=MongoDB.getLista_tareas();
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tareas</title>

</head>
<script type="text/javascript">
function muestra(valor){
   alert(valor);
  var manolo=<%=lista_tareas%>;
  manolo.get(valor);
   
}
</script>
<link rel="stylesheet" type="text/css" href="css/procesos.css" />
<body>
	<h2 style="text-align: center;">Bienvenido <%= user %> !</h2>	
	


<h1> Inicio</h1>


<div  id='marco'>
  <div id="contenedor">
     <div class="vertical">
      <h2>Usuario</h2><br>      
      <div class="contenido" id="cont">
      
      <%  	
      out.println(MongoDB.generar_tabla_tareas());
  	
      if(rol.equals("admin")){
    	  out.println("  <form action='interfaz_admin.jsp' method='post'><button type='submit' value='Panel Admin' name='Panel_admin'/>Panel Admin</button> <br> </form> ");
    	  
    	  //out.println("<button type='button' href='AdminUser.jsp'>Panel de Administracion de Usuarios</button> <br>   ");
      }
      %>
       <form action="tarea.jsp" method="post">        
        	<button type="submit" value="anadir" name="anadir">Añadir</button> <br> 
        </form>     
        <button type="button" >Modificar</button>    <br>
        <button type="button" >Eliminar</button>   <br>  
       <a href="/HelloSpring">Volver</a>     
      </div>
 	 </div>
</div>
 </div>
 <script type="text/javascript">
			  //mostrar_fecha(); // Invocar función
</script>
</body>
</body>
</html>