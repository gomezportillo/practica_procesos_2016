package com.esi.uclm.procesos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class tareaA�adida {
	@RequestMapping("/tareaA�adida")
	public ModelAndView helloSpring() {
		//String message = "Bienvenido jesusito de mi corazon, ";		
		//return new ModelAndView("bienvenido", "message", message);
		ModelAndView model = new ModelAndView("tareaA�adida");
		model.addObject("message", "Tarea A�adida");
		

		return model;
	}	
}
