package com.esi.uclm.procesos.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.sql.*;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esi.uclm.procesos.gestion.MongoDB;
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
		 // Guardar el nombre del cliente en la sesi�n para poderlo utilizar en el siguiente servlet
		 String usuarioSesion=(String) request.getSession().getAttribute("user");

		 */

		String id=request.getParameter("id");
		String nombre=request.getParameter("nombre");
		String prioridad=request.getParameter("prioridad");
		String[] pertenece =  request.getParameter("pertenece").split(",");
		Set<String> users = (Set<String>) Arrays.asList(pertenece);
		String fecha=request.getParameter("fecha");
		String notas=request.getParameter("notas");
		String estado=request.getParameter("estado");

		if(nombre!=null){
			Tarea t = new Tarea(id,nombre, prioridad, users, fecha, notas, estado);
			MongoDB.insertar_tarea(t);
		}
	}
}