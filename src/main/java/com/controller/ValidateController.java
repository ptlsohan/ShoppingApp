package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.User;

@Controller
public class ValidateController {
	
	
	@RequestMapping(path="/validate", method=RequestMethod.POST)
	//public ModelAndView isValid(@RequestParam("email")String email, @RequestParam("password")String pwd) {
		
	public ModelAndView isValid(@Valid @ModelAttribute("user") User user, BindingResult result) {	
		if(result.hasErrors()) {
			ModelAndView mv= new ModelAndView();
			mv.addObject("error",result.getAllErrors());
			mv.setViewName("register");
			return mv;
			
		}
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("user",user);
		mv.setViewName("display");
		return mv;
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.setDisallowedFields("confirm_password");
	}

}
