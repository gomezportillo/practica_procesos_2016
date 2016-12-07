package com.esi.uclm.procesos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class userAñadido {
	@RequestMapping("/user_añadido")
	public ModelAndView helloSpring() {
		//String message = "Bienvenido jesusito de mi corazon, ";		
		//return new ModelAndView("bienvenido", "message", message);
		ModelAndView model = new ModelAndView("user_añadido");
		model.addObject("message", "Usuario añadido ");
		return model;
	}	
}
