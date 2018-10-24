package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Mobile;
import com.dto.Product;
import com.service.MobileService;
import com.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired MobileService ms;
	@Autowired ProductService ps;
	
	@RequestMapping(path="/addProduct")
	public String addProduct() {
		
		
		
		return "categoryList";
	}
	
	@RequestMapping(path="/addProduct/mobile")
	public String mobileForm() {
		
		
		
		return "mobileForm";
	}
	@RequestMapping(path="/addProduct/addMobile",method=RequestMethod.POST)
	public ModelAndView addMobile(@Valid @ModelAttribute("mobile") Mobile mobile, BindingResult result) {
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()) {
			
			mv.addObject("error",result.getAllErrors());
			mv.setViewName("mobileForm");
			return mv;
			
		}
		ms.addProduct(mobile);
		mv.setViewName("mobileForm");
		return mv;
	}
	
	@RequestMapping(path="/displayProduct")
	public ModelAndView displayProduct(@RequestParam("start")int s) {
	ModelAndView mv= new ModelAndView("displayProduct");
	List<Product> products= ps.getAllProductByPage(s);
	mv.addObject("list",products);
	return mv;
	}
	@InitBinder
	public void init(WebDataBinder binder) {

	}

}
