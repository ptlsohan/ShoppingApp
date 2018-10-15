package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/fashion")
	public String getFashion(Model m) {
		m.addAttribute("page", "Fashion page");
		return "display";
	}
	
	@RequestMapping("/electronics")
	public String getElectronics(Model m) {
		m.addAttribute("page", "Electronics page");
		return "display";
	}
	@RequestMapping("/book")
	public String getBook(Model m) {
		m.addAttribute("page", "Book page");
		return "display";
	}
	@RequestMapping("/mobile")
	public String getMobile(Model m) {
		m.addAttribute("page", "Mobile page");
		return "display";
	}
	
}
