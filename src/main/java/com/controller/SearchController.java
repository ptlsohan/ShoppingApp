package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Address;
import com.dto.Cart;
import com.dto.Product;
import com.dto.User;
import com.service.AddressService;
import com.service.CartService;
import com.service.ProductService;
import com.service.UserService;

@Controller
public class SearchController {

	@Autowired ProductService ps;
	@Autowired AddressService addserv;
	@Autowired UserService us;
	@Autowired CartService cs;
	
	@GetMapping(path="/autocomplete", 
	produces= {MediaType.APPLICATION_JSON})
@ResponseBody
public List<String> getWelcomeResponse(@RequestParam String keyword) {
System.out.println(keyword);
System.out.println("in!!");

List<Product>product=ps.searchApi(keyword);
List<String> list=new ArrayList<>();
for(Product s: product ) {
	list.add(s.getName());
}
return list; //data which has to be returned
}
	
	@GetMapping(path="/fetchAddress", 
			produces= {MediaType.APPLICATION_JSON})
		@ResponseBody
		public Address fetchAddress(@RequestParam int id) {
		System.out.println(id);
		System.out.println("in!!");

		Address address=addserv.getAddresstById(id);
		System.out.println("address fetch"+address.toString());
	//	String gs =new Gson().toJson(address);
		return address; //data which has to be returned
		}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(path="/updateCart", 
			produces= {MediaType.TEXT_PLAIN})
	@ResponseBody
	public String updateCart(HttpSession session,
			@RequestParam("id") int id) {
		
		System.out.println("id "+id);
		
		Product p = ps.getProductById(id);
		User user = (User) session.getAttribute("user");
		System.out.println(p);
		if(user==null) {
			Map<Product,Integer> cart= (Map<Product, Integer>) session.getAttribute("cart");
			session.removeAttribute("user");
			if (cart.containsKey(p)) {
				cart.put(p, cart.get(p) - 1);
			} else {
				cart.put(p, 1);
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
				cartList.put(p, cartList.get(p) - 1);
			} else {
				cartList.put(p, 1);
			}
			if(isNewCart)
			{	//cs.updateProduct(c1);
				user.setCart(c1);
				user.setConfirmPassword(user.getPassword());
				us.updateUser(user);
			}
			else
			{
				cs.updateProduct(c1);
			}
			session.setAttribute("cartSize", c1.getCartList().size());
		}
		
		session.setAttribute("addMsg", "item added to cart");
		
		return "ok";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(path="/updateAddCart", 
			produces= {MediaType.TEXT_PLAIN})
	@ResponseBody
	public String updateAddCart(HttpSession session,
			@RequestParam("id") int id) {
		
		System.out.println("id "+id);
		
		Product p = ps.getProductById(id);
		User user = (User) session.getAttribute("user");
		System.out.println(p);
		if(user==null) {
			Map<Product,Integer> cart= (Map<Product, Integer>) session.getAttribute("cart");
			session.removeAttribute("user");
			if (cart.containsKey(p)) {
				cart.put(p, cart.get(p) + 1);
			} else {
				cart.put(p, 1);
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
				cartList.put(p, cartList.get(p) + 1);
			} else {
				cartList.put(p, 1);
			}
			if(isNewCart)
			{	//cs.updateProduct(c1);
				user.setCart(c1);
				user.setConfirmPassword(user.getPassword());
				us.updateUser(user);
			}
			else
			{
				cs.updateProduct(c1);
			}
			session.setAttribute("cartSize", c1.getCartList().size());
		}
		
		session.setAttribute("addMsg", "item added to cart");
		
		return "ok";
	}
	
}
