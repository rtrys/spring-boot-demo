package com.example.demo.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		// return "redirect:/app/index"; // cambia la ruta (crea un nuevo request)
		return "forward:/app/index"; // no cambia la ruta (no cambia request) solo rutas internas
	}
}
