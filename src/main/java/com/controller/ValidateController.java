package com.controller;


import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Cart;
import com.dto.Product;
import com.dto.User;
import com.dto.UserProfile;
import com.service.CartService;
import com.service.ProfileService;
import com.service.UserService;


@Controller
@SessionAttributes({"user","cart"})
public class ValidateController {
	
	@Autowired UserService us;
	@Autowired ProfileService pserv;
	@Autowired CartService cserv;
	
	@ModelAttribute("user")
	public User newUser() {
		return new User();
	}
	
	@RequestMapping("/profile")
	public ModelAndView profile(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView("profile");
		if(user==null || user.getUserId()==0) {
			mv.setViewName("login");
			return mv;
		}
		mv.addObject("user",user);
		System.out.println("profile"+user.getUsername());
		UserProfile profile=pserv.getProfileById(user.getUserId());
		mv.addObject("profile",profile);
		
		return mv;
	}
	
	@RequestMapping(path="/loginValidate")
	protected ModelAndView login(@Valid @ModelAttribute("user") User user, BindingResult result,SessionStatus status,
			HttpSession session,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int value=0;
		User u=null;
		try {
		u=us.getUserByUName(user.getUsername());
		}catch(NoSuchElementException e) {
			status.setComplete();
			mv.addObject("invalid",true);
			mv.addObject("msg","Invalid username/password");
			mv.setViewName("login");
			return mv;
		}
		if(u!=null && u.getPassword().equals(user.getPassword())) {
//			Map<Product,Integer> cart= (Map<Product, Integer>) session.getAttribute("cart");
			System.out.println("user cart"+u.getCart());
			Map<Product,Integer> cart= (Map<Product, Integer>) session.getAttribute("cart");
			if(cart!=null && !cart.isEmpty()) {
			if(u.getCart()==null) {
				Cart c1= new Cart();
				
				c1.setCartList(cart);
				c1.setUser(u);
				u.setCart(c1);
				//us.updateUser(user);
			//	u.setCart(c1);
				int id=cserv.addCart(c1);
				u.setConfirmPassword(u.getPassword());
				us.updateUser(u);
				value=cart.size();
				System.out.println("user cart"+u.getCart());
			}else if(u.getCart()!=null) {
				u.getCart().getCartList().putAll(cart);
				u.setConfirmPassword(u.getPassword());
				us.updateUser(u);
				cart.clear();
				value=u.getCart().getCartList().size();
				System.out.println("cart size"+value);
			}
			}else {
				if(u.getCart()!=null)
				value=u.getCart().getCartList().size();
			}
			System.out.println("cart size2"+value);
			session.setAttribute("cartSize", value);
			mv.addObject("invalid",false);
			mv.addObject("user",u);
//			String url = (String) req.getAttribute("url");
//			System.out.println("url from req"+url);
//			if("/OnlineShoppingApp/checkout".equals(url)) {
//				System.out.println("checkout");
//				mv.setViewName("redirect:"+url);
//				return mv;
//			}
			
			mv.setViewName("redirect:home");
			return mv;
		}
		status.setComplete();
		mv.addObject("msg","Invalid username/password");
		mv.addObject("invalid",true);
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(path="/logout")
	protected ModelAndView logout( @ModelAttribute("user") User user,SessionStatus status) {
		ModelAndView mv = new ModelAndView("redirect:home");
	
		status.setComplete();
		return mv;
	}
	
	
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.setDisallowedFields("confirmPassword");
	}

}
