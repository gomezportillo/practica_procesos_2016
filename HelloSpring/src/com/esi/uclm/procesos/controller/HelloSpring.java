package com.esi.uclm.procesos.controller;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Controller
public class HelloSpring {

	@RequestMapping("/bienvenido")
	public ModelAndView helloSpring() {
		String message = "Bienvenido jesusito de mi corazon, ";		
		return new ModelAndView("bienvenido", "message", message);
	}	
	public void conexionMongoDB() throws UnknownHostException {
		// TODO Auto-generated method stub
			MongoClient  mongoClient = new MongoClient("localhost");
			List<String> databases= mongoClient.getDatabaseNames();
			for(String dbName : databases){
				System.out.println(""+dbName);
				DB db=mongoClient.getDB(dbName);
				Set<String> collections=db.getCollectionNames();
				
				for(String colName: collections){
					System.out.println(""+colName);
				}
			}
			mongoClient.close();
	}
}