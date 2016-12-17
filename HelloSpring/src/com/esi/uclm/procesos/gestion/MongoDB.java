package com.esi.uclm.procesos.gestion;

import java.net.UnknownHostException;

import java.util.logging.Level;
import java.util.logging.Logger;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDB {
		public static MongoClient conexion() throws UnknownHostException{
			MongoClientURI uri  = new MongoClientURI("mongodb://juliky999:Informatica1@ds119768.mlab.com:19768/usuarios_prueba"); 
	        MongoClient mongoClient = new MongoClient(uri);
	        Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);
			
	      //  MongoClient mongoClient=new MongoClient("localhost");
			return mongoClient;
			
		}
	
		public static String comprobar_user_pass(String user, String password) throws UnknownHostException{
			MongoClient mongoClient=conexion();
	          
			String dbName="usuarios_prueba";
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
					if(theObj.get("password").equals(password))
					{
						rol=theObj.get("rol").toString();
					}
				}
			}
			
			mongoClient.close();
			return rol;
		}
		
		public static Boolean consultar_id(String id, String tabla) throws UnknownHostException{
			MongoClient mongoClient=conexion();
	          
			String dbName="usuarios_prueba";
			Boolean esta=false;
			if(id!=""){
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
				BasicDBObject query = new BasicDBObject();
				query.put("id", id); 
				DBCursor cursor = coll.find(query); 
				while (cursor.hasNext()) {
					DBObject theObj = cursor.next();
					System.out.println(theObj.toString());
					if(theObj.get("id").equals(id))
					{
					esta=true;
					}
				}
			}
			
			mongoClient.close();
			return esta;
		}
		public static int ultimoid(String dbName, String tabla) throws UnknownHostException{
			MongoClient mongoClient=conexion();
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			DBCursor cursor=coll.find();
			cursor.sort(new BasicDBObject("id", -1)).toString();
			int valor= Integer.parseInt((cursor.next().get("id").toString()))+1;
			
		
			return valor;
		}
		


		public static String generar_tabla_users() throws UnknownHostException{
			MongoClient mongoClient=conexion();
	          
		 	String dbName="usuarios_prueba";
			String tablaUsuarios="usuarios";
			
			
			DB db= mongoClient.getDB(dbName);
			DBCollection coll=db.getCollection(tablaUsuarios);
			DBCursor cursor=coll.find();
			
			
			String cadena="";
	    	cadena+="<table id='myTable' border=1><tr><th>Id</th><th>User</th><th>Email</th><th>Rol</th>";
	    	int i=0;;
	    	while (cursor.hasNext()) {
				DBObject theObj = cursor.next();
				String id=theObj.get("id").toString();
				String user = theObj.get("user").toString();
				String email = theObj.get("email").toString();
				String rol = theObj.get("rol").toString();
				i++;
				cadena+="<tr style='cursor: pointer' onclick='muestra("+i+")'><td>"+id+"</td><td>"+user+"</td><td>"+email+"</td><td>"+rol+"</td></tr>";
			}
	    		//System.out.println(cursor.next().get("prioridad"));
	    	cadena+="</table>";
			return cadena;
		}								
		public static String generar_tabla_tareas_usuario(String usuario,String campo_a_ordenar) throws UnknownHostException{
	        
	        MongoClient mongoClient=conexion();
	            
	        String dbName="usuarios_prueba";
	        String tabla="tareas";
	        String rol="";
			
	        DB db=mongoClient.getDB(dbName);
	        DBCollection coll= db.getCollection(tabla);
	        
	        int i=0;
	        String cadena="";
	         
	        cadena+="<table id='myTable' border=1><tr  bgcolor='#EBEBEB' style='vertical-align:middle'><th>id</th><th>Nombre</th><th>Prioridad</th><th>Fecha Limite</th><th>Estado</th><th>Pertenece</th><th>Notas</th></tr> ";
	          
	        //Buscar solo los usuario con el filtro dado
				BasicDBObject filtro = new BasicDBObject();
				filtro.put("pertenece", usuario);
				DBCursor cur = coll.find(filtro);
				if(campo_a_ordenar!="")
				{
					cur.sort(new BasicDBObject(campo_a_ordenar, 1)).toString();
				}
		    while (cur.hasNext()) {
				DBObject theObj = cur.next(); 
				Tarea t = new  Tarea(theObj.get("id").toString(),theObj.get("nombre").toString(), theObj.get("prioridad").toString(), theObj.get("pertenece").toString(), theObj.get("fecha").toString(), theObj.get("notas").toString(), theObj.get("estado").toString());
				i++;
				cadena+="<tr  style='cursor: pointer' onclick='muestra("+i+")'><td>"+t.getId()+"</td><td>"+t.getNombre()+"</td><td>"+t.getPrioridad()+"</td><td>"+t.getFecha()+"</td><td>"+t.getEstado()+"</td><td>"+t.getPertenece()+"</td><td>"+t.getNotas()+"</td></tr>";
	        }
	        
	        cadena+="</table>";
	        mongoClient.close();
	        return cadena;
	}
		public static String generar_tabla_tareas_admin()  throws UnknownHostException{

			MongoClient mongoClient=conexion();
	          
			String dbName="usuarios_prueba";
			String tabla="tareas";
			String rol="";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
				
		    DBCursor cursor = coll.find(); 
		    
		    int i=0;
		    String cadena="";
		    cadena+="<table border=1><tr bgcolor='#EBEBEB' style='vertical-align:middle'>"
		    			+ "<th>Nombre</th>"
		    			+ "<th>Prioridad</th>"
		    			+ "<th>Fecha limite</th>"
		    			+ "<th>Estado</th>"
		    			+ "<th>Pertenece</th>"
		    			+ "<th>Notas</th></tr>";
		    	
		    	
		    	
		    while (cursor.hasNext()) {
				DBObject theObj = cursor.next();
				Tarea t = new  Tarea(theObj.get("id").toString(),theObj.get("nombre").toString(), theObj.get("prioridad").toString(), theObj.get("pertenece").toString(), theObj.get("fecha").toString(), theObj.get("notas").toString(), theObj.get("estado").toString());
				
				cadena+="<tr style='cursor: pointer' onclick='muestra("+i+")'><td>"+t.getId()+"</td><td>"+t.getNombre()+"</td><td>"+t.getPrioridad()+"</td><td>"+t.getFecha()+"</td><td>"+t.getEstado()+"</td><td>"+t.getPertenece()+"</td><td>"+t.getNotas()+"</td></tr>";
				i++;
			}
		    		//System.out.println(cursor.next().get("prioridad"));
		    cadena+="</table>";
		  	mongoClient.close();
		  	return cadena;
		  		
		}
		public static void insertar_tarea(Tarea t) throws UnknownHostException{
			MongoClient mongoClient=conexion();
	          
			String dbName="usuarios_prueba";
			String tabla="tareas";
			String rol="";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			BasicDBObject doc = new BasicDBObject("id",t.getId()).append("nombre",t.getNombre()).append("prioridad",t.getPrioridad()).append("pertenece",t.getPertenece()).append("fecha",t.getFecha()).append("notas",t.getNotas()).append("estado",t.getEstado());
			coll.insert(doc);
			mongoClient.close();
		}
		public static void inserta_usuario(Usuario usuario) throws UnknownHostException {
			
			MongoClient mongoClient=conexion();
			String dbName="usuarios_prueba";
			String tabla="usuarios";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			BasicDBObject doc = new BasicDBObject("id", usuario.getId()).append("user", usuario.getUser()).append("password", usuario.getPassword()).append("email", usuario.getEmail()).append("rol", usuario.getRol());
			coll.insert(doc);
			mongoClient.close();			
		}
		

		public static void modificar_usuario(Usuario usuario) throws UnknownHostException {
		
			MongoClient mongoClient=conexion();
			String dbName="usuarios_prueba";
			String tabla="usuarios";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.append("$set", new BasicDBObject().append("user", usuario.getUser()).append("email", usuario.getEmail()).append("rol", usuario.getRol()));

			BasicDBObject searchQuery = new BasicDBObject().append("id", usuario.getId());

			coll.update(searchQuery, newDocument);
			mongoClient.close();
		}
		public static void modificar_tarea(Tarea tarea) throws UnknownHostException {
			
			MongoClient mongoClient=conexion();
			String dbName="usuarios_prueba";
			String tabla="tareas";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			
			DBCursor cursor=coll.find();			
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.append("$set", new BasicDBObject().append("nombre", tarea.getNombre()).append("prioridad", tarea.getPrioridad()).append("pertenece", tarea.getPertenece()).append("estado", tarea.getEstado()).append("fecha", tarea.getFecha()).append("notas", tarea.getNotas()));

			BasicDBObject searchQuery = new BasicDBObject().append("id", tarea.getId());
			coll.update(searchQuery, newDocument);
			
			mongoClient.close();
		}
		public static void eliminar_usuario(String id_usuario) throws UnknownHostException {
			
			MongoClient mongoClient=conexion();
			String dbName="usuarios_prueba";
			String tabla="usuarios";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			
			DBCursor cursor=coll.find();
			
			//DBObject usuarioEliminar=new BasicDBObject("user", usuario);
			//db.getCollection("users").find();
			coll.remove(new BasicDBObject("id",id_usuario));
			
			mongoClient.close();			
		}	
		
		public static void eliminar_tarea(String id_nombretarea) throws UnknownHostException {
			
			MongoClient mongoClient=conexion();
			String dbName="usuarios_prueba";
			String tabla="tareas";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			
			DBCursor cursor=coll.find();
			
			//DBObject usuarioEliminar=new BasicDBObject("user", usuario);
			//db.getCollection("users").find();
			coll.remove(new BasicDBObject("id",id_nombretarea));
			
			
			mongoClient.close();			
		}	
/*
		public static ArrayList<Tarea> generar_list_tareas() throws UnknownHostException{
			
			//MongoClient mongoClient = new MongoClient("localhost");
			ArrayList<Tarea> lista_tarea = new ArrayList<Tarea>();
			MongoClient mongoClient=conexion();
	          
			 	String dbName="usuarios_prueba";
				String tabla="tareas";
				
				DB db=mongoClient.getDB(dbName);
				DBCollection coll= db.getCollection(tabla);				
		    	 
				
				
				BasicDBObject filtro = new BasicDBObject();
				filtro.put("user", "pablo");
				 System.out.println("eeeeeeeeeeeeeeeeeeee");
				DBCursor cur = coll.find(filtro);
				while (cur.hasNext())
				  System.out.println(cur.next());
				System.out.println("eeeeeeeeeeeeeeeeeeee");
				
				
				
				
		    	
		    	BasicDBObject query = new BasicDBObject();
		    	query.put("name", new BasicDBObject("$regex", "pablo").append("$options","pablo"));
		    	
		    	
		    	DBCursor cursor = coll.find(query); 
		    	while(cursor.hasNext()){
		    			DBObject theObj = cursor.next();
		    			System.out.print(theObj.get("name").toString());
						//Tarea t = new  Tarea(theObj.get("nombre").toString(), theObj.get("prioridad").toString(), theObj.get("pertenece").toString(), theObj.get("fecha").toString(), theObj.get("notas").toString(), theObj.get("estado").toString());
						//lista_tarea.add(t);	
						 
			
		    	}
		    	
		    	
		    	//while (cursor.hasNext()) {
				//	DBObject theObj = cursor.next();
				//	Tarea t = new  Tarea(theObj.get("nombre").toString(), theObj.get("prioridad").toString(), theObj.get("pertenece").toString(), theObj.get("fecha").toString(), theObj.get("notas").toString(), theObj.get("estado").toString());
				//	lista_tarea.add(t);					
				//}
				 * 
				 
		    	
		  		mongoClient.close();
		  		return lista_tarea;
		}	 
*/
}
