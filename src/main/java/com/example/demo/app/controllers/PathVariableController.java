package com.example.demo.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path-variables")
public class PathVariableController {
	
	@GetMapping("/string/{message}")
	public String variables(@PathVariable String message, Model model) {
		
		model.addAttribute("message", message);
		
		return "variables/ver";
	}

	@GetMapping("/string/{message}/{number}")
	public String variables(
			@PathVariable String message,
			@PathVariable Integer number,
			Model model
		) {
		
		model.addAttribute("message", message);
		model.addAttribute("number", number);
		
		return "variables/mix";
	}
}
