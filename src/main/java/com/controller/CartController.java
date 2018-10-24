package com.controller;

import java.util.HashMap;

import java.util.Map;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.ModelAndView;

import com.dto.Address;
import com.dto.Cart;
import com.dto.CreditCard;
import com.dto.Order;
import com.dto.Product;
import com.dto.User;
import com.service.CartService;
import com.service.OrderService;
import com.service.ProductService;
import com.service.UserService;

@Controller
@SessionAttributes({"cart"}) 
public class CartController {

	@Autowired ProductService ps;
	@Autowired UserService us;
	@Autowired CartService cs;
	@Autowired OrderService os;
	
	@ModelAttribute("cart")
	public Map<Product,Integer> newCart() {
		return new HashMap<>();
	}
	
	
	@RequestMapping("/addToCart")
	public ModelAndView addToCart(HttpSession session,
			@ModelAttribute("cart") Map<Product,Integer> cart,@RequestParam("quantity") int quantity,
			@RequestParam("id") int id,@RequestParam("category") String category) {
		ModelAndView mv = new ModelAndView("redirect:"+category+"/"+id);
		
		
		Product p = ps.getProductById(id);
		User user = (User) session.getAttribute("user");
		System.out.println(p);
		if(user==null) {
			
			session.removeAttribute("user");
			if (cart.containsKey(p)) {
				cart.put(p, cart.get(p) + quantity);
			} else {
				cart.put(p, quantity);
			}
		}else {
			Boolean isNewCart = false;
			Cart c1=user.getCart();
			if (c1 == null) {	
				c1 = new Cart();
				isNewCart=true;
				user.setCart(c1);
			}
			Map<Product, Integer> cartList = c1.getCartList();
			if (cartList.containsKey(p)) {
				cartList.put(p, cartList.get(p) + quantity);
			} else {
				cartList.put(p, quantity);
			}
			if(isNewCart)
			{	//cs.updateProduct(c1);
				user.setCart(c1);
				us.updateUser(user);
			}
			else
			{
				cs.updateProduct(c1);
			}
			session.setAttribute("cartSize", c1.getCartList().size());
		}
		
		session.setAttribute("addMsg", "item added to cart");
		
		return mv;
	}
	
	@RequestMapping("/showCart")
	public ModelAndView showCart(HttpSession session,
			@ModelAttribute("cart") Map<Product,Integer> cart) {
		ModelAndView mv = new ModelAndView("showCart");
		session.removeAttribute("addMsg");
		User user = (User) session.getAttribute("user");
		if(user==null) {
			mv.addObject("list",cart);
			double total=0;
			 for(Map.Entry<Product,Integer> entry: cart.entrySet()) {
				 int count=entry.getValue();
				 double price=entry.getKey().getPrice();
				 total+=count*price;
			 }
			 
			 mv.addObject("total",total);
		}else {
		User ucart=cs.getProductById(user.getUserId());
		if(ucart.getCart()==null) {
			mv.addObject("msg","Cart is empty");
		}else {
		Map<Product,Integer> list =ucart.getCart().getCartList();
		mv.addObject("list",list);
		double total=0;
		 for(Map.Entry<Product,Integer> entry: list.entrySet()) {
			 int count=entry.getValue();
			 double price=entry.getKey().getPrice();
			 total+=count*price;
		 }
		
		 mv.addObject("total",total);
		}
		
		}
		
		return mv;
	}
	
	@RequestMapping(path="/deleteItem",method=RequestMethod.POST)
	public ModelAndView deleteItem(HttpSession session,
			@ModelAttribute("cart") Map<Product,Integer> cart,@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("redirect:showCart");

		Product p = ps.getProductById(id);
		
		
		User user = (User) session.getAttribute("user");
		if(user==null) {
			if (cart.containsKey(p)) {
				cart.remove(p);
			} 
			mv.addObject("list",cart);
		}else {
			Cart c1=user.getCart();
			Map<Product, Integer> cartList = c1.getCartList();
			
			if (cartList.containsKey(p)) {
				cartList.remove(p);
			} 
			cs.updateProduct(c1);
			session.setAttribute("cartSize", c1.getCartList().size());
			
		User ucart=cs.getProductById(user.getUserId());
		Map<Product,Integer> list =ucart.getCart().getCartList();
		mv.addObject("list",list);
		
		}
		
		return mv;
	}
	
	@RequestMapping("/checkout")
	public ModelAndView checkout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		if(user==null) {
			mv.setViewName("forward:login");
			
		}else {
		User ucart=cs.getProductById(user.getUserId());
		Map<Product,Integer> list =ucart.getCart().getCartList();
		double total=0;
		 for(Map.Entry<Product,Integer> entry: list.entrySet()) {
			 int count=entry.getValue();
			 double price=entry.getKey().getPrice();
			 total+=count*price;
		 }
		 mv.setViewName("checkout");
		 mv.addObject("total",total);
		 mv.addObject("list",list);
		
		}
		
		return mv;
	}
	
	
	@RequestMapping("/makePayment")
	public ModelAndView makePayment(HttpSession session,@Valid @ModelAttribute("order") Order order,
			@Valid @ModelAttribute("address") Address address,@Valid @ModelAttribute("card") CreditCard card, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView mv= new ModelAndView();
			mv.addObject("error",result.getAllErrors());
			mv.setViewName("checkout");
			return mv;
			
		}
		
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		if(user==null) {
			mv.setViewName("redirect:login");
		}else {
			mv.setViewName("redirect:successPage");
			User ucart=cs.getProductById(user.getUserId());
			Map<Product,Integer> list =ucart.getCart().getCartList();
			order.setProductList(list);
			order.setAddress(address);
			order.setCard(card);
			order.setUser(user);
			int id=os.addOrder(order);
			//cs.deleteProduct(ucart.getCart());
			ucart.setCart(null);
			us.updateUser(ucart);
			session.setAttribute("orderId",id);
			mv.addObject("orderId",id);
			session.setAttribute("order",order);
			
		}
		
		
		return mv;
	}
	
	@RequestMapping("/successPage")
	public ModelAndView successPage(HttpSession session) {
		session.setAttribute("cartSize", 0);
		ModelAndView mv=new ModelAndView("successPage");
		mv.addObject("orderId",session.getAttribute("orderId"));
		mv.addObject("order",session.getAttribute("order"));
		session.removeAttribute("order");
		session.removeAttribute("orderId");
		
		return mv;
	}
	
	
}
