package com.esi.uclm.procesos.controller;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.codecs.configuration.CodecConfigurationException;

import com.mongodb.BasicDBObject;
import com.mongojjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjdbxxx.DB;
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
					rol=theObj.get("rol").toString();
				}
			}
			mongoClient.close();
			return rol;
		}
		public static void Consulta(String bbddName, String tabla) throws UnknownHostException{
			MongoClient mongoClient=conexion();
			DB db= mongoClient.getDB(bbddName);
			DBCollection coll=db.getCollection(tabla);
			DBCursor cursor=coll.find();
			//int i =1;
			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}
		}

		public static String generar_tabla_users(String bbddName, String tabla) throws UnknownHostException{
			MongoClient mongoClient=conexion();
			DB db= mongoClient.getDB(bbddName);
			DBCollection coll=db.getCollection(tabla);
			DBCursor cursor=coll.find();
			
			String cadena="";
	    	cadena+="<table border=1><tr><th>User</th><th>Email</th><th>Rol</th>";
	    	
	    	while (cursor.hasNext()) {
				DBObject theObj = cursor.next();
				String user = theObj.get("user").toString();
				String email = theObj.get("email").toString();
				String rol = theObj.get("rol").toString();
				
				cadena+="<tr><td>"+user+"</td><td>"+email+"</td><td>"+rol+"</td></tr>";
			}
	    		//System.out.println(cursor.next().get("prioridad"));
	    	cadena+="</table>";
			
			return cadena;
		}
		
		public static String generar_tabla_tareas() throws UnknownHostException{
			//MongoClient mongoClient = new MongoClient("localhost");
			MongoClient mongoClient=conexion();
	          
			 	String dbName="usuarios_prueba";
				String tabla="tareas";
				String rol="";
				DB db=mongoClient.getDB(dbName);
				DBCollection coll= db.getCollection(tabla);
				
		    	DBCursor cursor = coll.find(); 
		    
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
		  		mongoClient.close();
		  		return cadena;
		}
		
		public static void insertar_tarea(String nombre, String prioridad, String pertenece, String fecha, String notas, String estado) throws UnknownHostException{
			MongoClient mongoClient=conexion();
	          
			String dbName="usuarios_prueba";
			String tabla="tareas";
			String rol="";
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			BasicDBObject doc = new BasicDBObject("nombre",nombre).append("prioridad",prioridad).append("pertenece",pertenece).append("fecha",fecha).append("notas",notas).append("estado",estado);
			coll.insert(doc);
			mongoClient.close();
		}
		public static void inserta_usuario(String user, String password, String email, String rol) throws UnknownHostException {
			MongoClient mongoClient=conexion();
			String dbName="usuarios_prueba";
			String tabla="usuarios";
			
			DB db=mongoClient.getDB(dbName);
			DBCollection coll= db.getCollection(tabla);
			BasicDBObject doc = new BasicDBObject("user", user).append("password", password).append("email", email).append("rol", rol);
			coll.insert(doc);
			mongoClient.close();			
		}
		
}
