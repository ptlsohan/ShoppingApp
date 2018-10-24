package com.controller;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Order;

import com.dto.User;
import com.exception.DBException;
import com.service.OrderService;

@Controller
public class OrderController {
	@Autowired OrderService oserv;
	
	@RequestMapping("/showOrder")
	public ModelAndView showOrder(HttpSession session) {
		ModelAndView mv = new ModelAndView("showOrder");
		User user = (User) session.getAttribute("user");
		if(user==null) {
			
			 mv.setViewName("redirect:login");
			 return mv;
		}
		
		List<Order>ordList=oserv.getProductByUserId(user.getUserId());
		mv.addObject("list",ordList);
		System.out.println(ordList);
		return mv;
	}
	
	@RequestMapping("/deleteOrder")
	public ModelAndView deleteOrder(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView("redirect:showOrder");
		
		
		try {
			oserv.deleteOrder(id);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			mv.addObject("error",e.getMessage());
			//mv.setViewName("redirect:home");
		}
		
		
		return mv;
	}
	
}
