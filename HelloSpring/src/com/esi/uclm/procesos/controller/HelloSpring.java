package com.esi.uclm.procesos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpring {

	@RequestMapping("/bienvenido")
	public ModelAndView helloSpring() {
		String message = "Bienvenido, ";
		return new ModelAndView("bienvenido", "message", message);
	}
}