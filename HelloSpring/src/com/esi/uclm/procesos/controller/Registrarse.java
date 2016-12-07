package com.esi.uclm.procesos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Registrarse {
	@RequestMapping("/registrarse")
	public ModelAndView helloSpring() {
		ModelAndView model = new ModelAndView("registrarse");
		model.addObject("msg", "registrarse");
		return model;
	}	
}
