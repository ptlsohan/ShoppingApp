package com.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Address;
import com.dto.Book;
import com.dto.Fashion;
import com.dto.Laptop;
import com.dto.Mobile;
import com.dto.Product;
import com.dto.User;
import com.dto.UserProfile;
import com.service.AddressService;
import com.service.BookService;
import com.service.FashionService;
import com.service.LaptopService;
import com.service.MobileService;
import com.service.ProductService;
import com.service.ProfileService;
import com.service.UserService;

@Controller
public class HomeController {
	@Autowired UserService us;
	@Autowired AddressService addserv;
	@Autowired MobileService mserv;
	@Autowired FashionService fserv;
	@Autowired BookService bserv;
	@Autowired LaptopService lserv;
	
	
	@Autowired ProfileService pserv;
	

	@Autowired ProductService ps;
	
	
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(path="/error")
	protected String error() {
		
		return "error";
	}
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("invalid", false);
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	
//	@RequestMapping("/fashion")
//	public ModelAndView getFashion() {
//		ModelAndView mv= new ModelAndView("displayProduct");
//		List<Product> products= ps.getProductByCategory("fashion");
//		mv.addObject("list",products);
//		return mv;
//	}
//	
//	@RequestMapping("/laptop")
//	public ModelAndView getElectronics() {
//		ModelAndView mv= new ModelAndView("displayProduct");
//		List<Product> products= ps.getProductByCategory("laptop");
//		mv.addObject("list",products);
//		return mv;
//	}
//	@RequestMapping("/book")
//	public ModelAndView getBook() {
//		ModelAndView mv= new ModelAndView("displayProduct");
//		List<Product> products= ps.getProductByCategory("book");
//		mv.addObject("list",products);
//		return mv;
//	}
	@RequestMapping(path="/{category}",params= {"start"})
	public ModelAndView getMobile(@PathVariable("category") String category,@RequestParam("start")int s) {
		
		ModelAndView mv= new ModelAndView("displayProduct");
		List<Product> products= ps.getProductByPage(category,s);
		mv.addObject("category",category);
		System.out.println("Category"+category);
		mv.addObject("list",products);
		return mv;
		
	}

	@Order(value=Ordered.LOWEST_PRECEDENCE)
	@RequestMapping("/{category}/{id}")
	public ModelAndView getProductInfo(@PathVariable("category") String category,@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("productInfo");
		System.out.println("Category"+category);
		Product p=null;
		if("mobile".equalsIgnoreCase(category)) {
			int qty=ps.getQty(id);
			System.out.println("quantity"+qty);
			p=mserv.getMobileById(id);
			mv.addObject("product",p);
		}
		else if("fashion".equalsIgnoreCase(category)) {
			p=fserv.getFashionById(id);
			mv.addObject("product",p);
		}else if("book".equalsIgnoreCase(category)) {
			p=bserv.getBookById(id);
			System.out.println("req methd"+p);
			mv.addObject("product",p);
		}
		else if("laptop".equalsIgnoreCase(category)) {
			p=lserv.getLaptopById(id);
			mv.addObject("product",p);
		}
		
		
		return mv;
	}
	
	
	@RequestMapping("/search")
	public ModelAndView searchProduct(@RequestParam("category")String category,@RequestParam("keyword")String key ) {
		ModelAndView mv= new ModelAndView("displayProduct");
		
		if("mobile".equals(category)) {
			List<Mobile> products=mserv.searchProduct(key);
			mv.addObject("list",products);
		}else if("fashion".equals(category)){
			List<Fashion> products=fserv.searchProduct(key);
			mv.addObject("list",products);
		}else if("laptop".equals(category)){
			List<Laptop> products=lserv.searchProduct(key);
			mv.addObject("list",products);
		}else if("book".equals(category)){
			List<Book> products=bserv.searchProduct(key);
			mv.addObject("list",products);
		}else {
			List<Product> products= ps.searchProduct(key);
			mv.addObject("list",products);
		}
		
		return mv;
	}
	
	
	
	@RequestMapping(path="/updateProfile", method=RequestMethod.POST)	
	public ModelAndView updateProfile(@Valid @ModelAttribute("profile") UserProfile profile, BindingResult result) {	
		if(result.hasErrors()) {
			ModelAndView mv= new ModelAndView();
			mv.addObject("error",result.getAllErrors());
			mv.setViewName("profile");
			return mv;
			
		}
		
		ModelAndView mv= new ModelAndView();
		//int id=pserv.addUserProfile(profile);
		
		pserv.updateProfile(profile);
		//user.setUserId(id);
		
		mv.addObject("profile",profile);
		
		mv.setViewName("profile");
		return mv;
	}
	
	@RequestMapping(path="/validate", method=RequestMethod.POST)	
	public ModelAndView isValid(@Valid @ModelAttribute("user") User user, BindingResult result,@Valid @ModelAttribute("profile") UserProfile profile,
		 BindingResult result1) {	
		if(result.hasErrors()) {
			System.out.println("regisetr error");
			ModelAndView mv= new ModelAndView();
			mv.addObject("error",result.getAllErrors());
			mv.setViewName("register");
			return mv;
			
		}
		if(result1.hasErrors()) {
			System.out.println("regisetr error");
			ModelAndView mv= new ModelAndView();
			mv.addObject("error",result1.getAllErrors());
			mv.setViewName("register");
			return mv;
			
		}
		
		ModelAndView mv= new ModelAndView();
		//int id=us.addUser(user);
		us.addUser(user);

		profile.setUser(user);
		user.setUserProfile(profile);
		int id=pserv.addUserProfile(profile);
		
		
	//	profile.setProfileId(id);
		Address address= new Address();
		address.setProfile(profile);
		addserv.addAddress(address);
		//user.setUserId(id);
		mv.addObject("user",user);
		mv.setViewName("login");
		return mv;
	}
	@InitBinder
	public void init(WebDataBinder binder) {
		//binder.setDisallowedFields("confirm_password");
	}
	
}
