package com.esi.uclm.procesos.controller;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Tareas {

	@RequestMapping("/tarea")
	public ModelAndView helloSpring() {
		//String message = "Bienvenido jesusito de mi corazon, ";		
		//return new ModelAndView("bienvenido", "message", message);
		ModelAndView model = new ModelAndView("tarea");
		model.addObject("msg", "hello world");

		return model;
	}	
	
}