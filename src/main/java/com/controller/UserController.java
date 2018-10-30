package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Address;
import com.dto.User;
import com.dto.UserProfile;
import com.service.AddressService;
import com.service.ProfileService;

@Controller
public class UserController {
	
	@Autowired AddressService addserv;
	@Autowired ProfileService pserv;
	
@RequestMapping("addAddressForm")
public String addAddressForm(HttpSession session) {
	User user=(User) session.getAttribute("user");
	if(user==null || user.getUserId()==0) {
		
		return "login";
	}
	
	return "addAddress";
}

@RequestMapping("addAddress")
public ModelAndView addAddress(HttpSession session,@ModelAttribute("address") Address address) {
	ModelAndView mv =new ModelAndView("redirect:addressList");
	User user=(User) session.getAttribute("user");
	if(user==null || user.getUserId()==0) {
		mv.setViewName("login");
		return mv;
	}
	address.setProfile(user.getUserProfile());
	addserv.addAddress(address);
	user.getUserProfile().getAddress().add(address);

	return mv;
}

@RequestMapping("addressList")
public ModelAndView addressList(HttpSession session,@ModelAttribute("address") Address address) {
	ModelAndView mv =new ModelAndView("addressList");
	
	User user=(User) session.getAttribute("user");
	if(user==null || user.getUserId()==0) {
		mv.setViewName("login");
		return mv;
	}
	//List<Address> addresses =user.getUserProfile().getAddress();
	UserProfile profile= pserv.getProfileById(user.getUserId());
	List<Address> addresses =profile.getAddress();
	mv.addObject("addresses",addresses);

	return mv;
}


@RequestMapping("editAddress")
public ModelAndView editAddress(HttpSession session,@RequestParam("id")int id) {
	ModelAndView mv =new ModelAndView("editAddress");
	User user=(User) session.getAttribute("user");
	if(user==null || user.getUserId()==0) {
		mv.setViewName("login");
		return mv;
	}
	Address address=addserv.getAddresstById(id);
	mv.addObject("address", address);
	
	return mv;
}

@RequestMapping("updateAddress")
public ModelAndView updateAddress(HttpSession session,@ModelAttribute("address") Address address) {
	ModelAndView mv =new ModelAndView("redirect:addressList");
	User user=(User) session.getAttribute("user");
	if(user==null || user.getUserId()==0) {
		mv.setViewName("login");
		return mv;
	}
	address.setProfile(user.getUserProfile());
	addserv.updateAddress(address);
	user.getUserProfile().getAddress().add(address);
	
	return mv;
	
}

@RequestMapping("removeAddress")
public ModelAndView removeAddress(HttpSession session,@RequestParam("id") int id) {
	ModelAndView mv =new ModelAndView("redirect:addressList");
	User user=(User) session.getAttribute("user");
	if(user==null || user.getUserId()==0) {
		mv.setViewName("login");
		return mv;
	}
	//address.setProfile(user.getUserProfile());
	Address address=addserv.getAddresstById(id);
	addserv.deleteAddress(address);
	//user.getUserProfile().getAddress().add(address);
	
	return mv;
	
}


}
