package com.esi.uclm.procesos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class tareaAñadida {
	@RequestMapping("/tareaAñadida")
	public ModelAndView helloSpring() {
		//String message = "Bienvenido jesusito de mi corazon, ";		
		//return new ModelAndView("bienvenido", "message", message);
		ModelAndView model = new ModelAndView("tareaAñadida");
		model.addObject("message", "Tarea Añadida");
		

		return model;
	}	
}
