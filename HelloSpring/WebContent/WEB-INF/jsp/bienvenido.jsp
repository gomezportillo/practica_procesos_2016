<%@page import="com.mongodb.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Set" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String user = request.getParameter("user");
	String password = request.getParameter("password");
	
	MongoClient mongoClient = new MongoClient("localhost");
	String dbName="procesos";
	String tabla="usuarios";
	String rol="";
	DB db=mongoClient.getDB(dbName);
	DBCollection coll= db.getCollection(tabla);
			
	if(user!="" && password!="")
	{
		BasicDBObject query = new BasicDBObject();
		query.put("user", user); 
		DBCursor cursor = coll.find(query); 
		while (cursor.hasNext()) {
			DBObject theObj = cursor.next();
			System.out.println(theObj.toString());
			System.out.println(theObj.get("user")+" rol "+theObj.get("rol"));
			rol=theObj.get("rol").toString();
		}
	}
	
	mongoClient.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Spring - Welcome !</title>
<script type="text/javascript">

function mostrar_fecha() {
 var tareas=[{nombre:"Pablo  Gonzalez",Prioridad:"1",Fecha_limite:"20/12/2016",Estado:"Pendiente",Perteneces:"Proyecto 1"},
	{nombre:"Alvaro Alonso",Prioridad:"3",Fecha_limite:"20/12/2016",Estado:"Completada",Perteneces:"Proyecto 2"}];
	var cadena,botones;
	cadena="";
	botones="";
 	var cl = document.getElementById("cont");
   
	cadena +='<table border=1><tr><th>Nombre</th><th>Prioridad</th><th>Fecha Limite</th><th>Estado</th><th>Pertenece</th></tr>';

	  
  for (i = 0; i < tareas.length; i++) {
    cadena +='<tr><td>'+tareas[i].nombre+'</td><td>'+tareas[i].Prioridad+'</td><td>'+tareas[i].Fecha_limite+'</td><td>'+tareas[i].Estado+'</td><td>'+tareas[i].Perteneces+'</td></tr>';
	}
	
  cadena +='</table>';
  botones=cl.outerHTML;
  cl.innerHTML=cadena+botones;
}
</script>
</head>
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
      if(rol.equals("admin")){
    	  out.println(" <a href='AdminUser.jsp'>Panel de Administracion de Usuarios</a>");
    	  
    	  //out.println("<button type='button' href='AdminUser.jsp'>Panel de Administracion de Usuarios</button> <br>   ");
      }
      %>
      
        <button type="button" onclick="location.href='tarea.jsp'">Añadir</button> <br>        
        <button type="button" >Modificar</button>    <br>
        <button type="button" >Eliminar</button>   <br>  
       <a href="/HelloSpring">Volver</a>     
      </div>
 	 </div>
</div>
 </div>
 <script type="text/javascript">
			  mostrar_fecha(); // Invocar función
</script>
</body>
</body>
</html>