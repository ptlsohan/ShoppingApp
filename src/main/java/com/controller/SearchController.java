package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Address;
import com.dto.Product;
import com.google.gson.Gson;
import com.service.AddressService;
import com.service.ProductService;

@Controller
public class SearchController {

	@Autowired ProductService ps;
	@Autowired AddressService addserv;
	
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
	
}
