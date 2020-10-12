package com.example.demo.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${text.controller.title}")
	private String generalTitle;

	@GetMapping({ "/", "/index", "/home" })
	public String index(Model model) {
		model.addAttribute("title", generalTitle);
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		
		user.setFirstName("Hugo");
		user.setLastName("Ortiz");
		user.setEmail("asdf@gmail.com");

		model.addAttribute("title", "Perfil de usuario: " + user.getFirstName());
		model.addAttribute("user", user);

		return "profile";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
//		List<User> users = new ArrayList<>();
//		
//		users.add(new User("Hugo", "Ortiz", "asdf@gmail.com"));
//		users.add(new User("Juan", "Perez", "1234@gmail.com"));
//		users.add(new User("Juanito", "Bazooka", "zxcv@gmail.com"));
		
		model.addAttribute("title", "Listado de usuarios");
//		model.addAttribute("users", users);

		return "list";
	}
	
	@ModelAttribute("users")
	public List<User> populateUsers() {
		List<User> users = new ArrayList<>();
		
		users.add(new User("Hugo", "Ortiz", "asdf@gmail.com"));
		users.add(new User("Juan", "Perez", "1234@gmail.com"));
		users.add(new User("Juanito", "Bazooka", "zxcv@gmail.com"));

		return users;
	}
}
