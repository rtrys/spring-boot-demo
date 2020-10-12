package com.example.demo.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsExampleController {

	@GetMapping("/index")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String params(@RequestParam(required = false) String message, Model model) {
		
		model.addAttribute("message", "El valor recibido es: " + message);

		return "params/ver";
	}

	@GetMapping("/mix-anotations")
	public String params(@RequestParam String message, @RequestParam Integer number, Model model) {
		
		model.addAttribute("message", "El valor del texto recibido es: " + message);
		model.addAttribute("number", "El valor del numero recibido es: " + number);

		return "params/mix";
	}

	@GetMapping("/mix-request")
	public String params(HttpServletRequest request, Model model) {
		
		String message = request.getParameter("message");
		Integer number = Integer.parseInt(request.getParameter("number"));
		
		model.addAttribute("message", "El valor del texto recibido es: " + message);
		model.addAttribute("number", "El valor del numero recibido es: " + number);

		return "params/mix";
	}
}
