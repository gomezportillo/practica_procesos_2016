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
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tareas</title>

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
      DBCollection coll2= db.getCollection("tareas");
    	DBCursor cursor = coll2.find(); 
    
    	int i=0;
    	String cadena="";
    	cadena+="<table border=1><tr><th>Nombre</th><th>Prioridad</th><th>Fecha Limite</th><th>Estado</th><th>Pertenece</th><th>Notas</th></tr> ";
    	
    	while (cursor.hasNext()) {
			DBObject theObj = cursor.next();
			String nombre = theObj.get("nombre").toString();
			String prioridad = theObj.get("prioridad").toString();
			String pertenece =theObj.get("pertenece").toString();
			String fecha= theObj.get("fecha").toString();
			String notas= theObj.get("notas").toString();
			String estado= theObj.get("estado").toString();
			
			cadena+="<tr><td>"+nombre+"</td><td>"+prioridad+"</td><td>"+fecha+"</td><td>"+estado+"</td><td>"+pertenece+"</td><td>"+notas+"</td></tr>";
		}
    		
    		//System.out.println(cursor.next().get("prioridad"));
    		
    		
    	
    	cadena+="</table>";
    	out.println(cadena);
  	
  		mongoClient.close();
  	
      if(rol.equals("admin")){
    	  out.println("  <form action='interfaz_admin.jsp' method='post'><button type='submit' value='Panel Admin' name='Panel_admin'/>Panel Admin</button> <br> </form> ");
    	  
    	  //out.println("<button type='button' href='AdminUser.jsp'>Panel de Administracion de Usuarios</button> <br>   ");
      }
      %>
       <form action="tarea.jsp" method="post">        
        	<button type="submit" value="Añadir" name="Añadir"/>Añadir</button> <br>
        </form>     
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