package com.esi.uclm.procesos.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esi.uclm.procesos.gestion.Tarea;
import com.esi.uclm.procesos.controller.*;

@WebServlet("/GestionUsuario")
public class GestionUsuario extends HttpServlet
{
	 private Connection conexion;
	 private Statement set;
	 private ResultSet rs;
	 String cad;
	 MongoClientURI uri;
	 

	 public void init(ServletConfig cfg) throws ServletException
	 {
	System.out.println("Lega aqui");
		 this.uri  = new MongoClientURI("mongodb://juliky999:Informatica1@ds119768.mlab.com:19768/usuarios_prueba"); 
		 super.init(cfg);

		
/*	
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	 con = DriverManager.getConnection(sURL, userName, password);
	 System.out.println("Se ha conectado");
	 }
	 catch(Exception e)
	 {
	 System.out.println( "No se ha conectado");
	 }
	*/
	 }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException
	 {
		 // Obtener la sesion
		 HttpSession s = request.getSession(true);
		/* 
		 // Guardar el nombre del cliente en la sesión para poderlo utilizar en el siguiente servlet
		 String usuarioSesion=(String) request.getSession().getAttribute("user");

	 	*/
		 System.out.println("Lega aqui2");
		String nombre=request.getParameter("nombre");
		String prioridad=request.getParameter("prioridad");
		String pertenece=request.getParameter("pertenece");
		String fecha=request.getParameter("fecha");
		String notas=request.getParameter("notas");
		String estado=request.getParameter("estado");
		
		if(nombre!=null){
				Tarea t=new Tarea(nombre, prioridad, pertenece, fecha, notas, estado);
				MongoDB.insertar_tarea(t);
			}
	
/*
	 try 
	 {
		 set = con.createStatement();
		 rs = set.executeQuery("SELECT * FROM Jugadores");
		 while (rs.next())
		 {
		 cad = rs.getString("Nombre");
		 cad = cad.trim();
		 if (cad.compareTo(nombre.trim())==0)
		 existe = true;
		 }
		 rs.close();
		 set.close();
		 }
		 catch(Exception e)
		 {
		 System.out.println("No lee de la tabla");
		 }
		 try
		 {
		 set = con.createStatement();
		 if (existe)
		 set.executeUpdate( "UPDATE Jugadores SET votos=votos+1 " +
		 "WHERE nombre LIKE '%" + nombre + "%'");
		 else
		 set.executeUpdate( "INSERT INTO Jugadores " +
		 "(nombre,votos) VALUES ('" + nombre + "',1)");
		 rs.close();
		 set.close();
		 }
		 catch(Exception e)
		 {
		 System.out.println( "No inserta ni modifica la tabla");
		 }
		 // Llamada al servlet que nos visualiza
		 // las estadísticas de jugadores
		 res.sendRedirect(res.encodeRedirectURL("./TablaVotos.jsp"));
		 }
		 public void doGet(HttpServletRequest req, HttpServletResponse res)
		 throws ServletException, IOException
		 {
		 try{doPost(req,res);}catch (Exception e)
		 {
		 }
		 }
		 public void destroy()
		 {
		 try {
		 con.close();
		 }
		 catch (Exception e)
		 {
		 }
		 super.destroy();
		 }
		 */
	 }
}