package com.esi.uclm.procesos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpring {

	@RequestMapping("/interfaz_user")
	public ModelAndView helloSpring() {
		ModelAndView model = new ModelAndView("interfaz_user");
		model.addObject("msg", "hello world");
		return model;
	}	
	
}