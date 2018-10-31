package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Cart;
import com.dto.User;
import com.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired CartRepository crep;


	@Override
	public User getProductById(int id) {
		// TODO Auto-generated method stub
		return crep.getProductById(id);
	}

	@Override
	public void updateProduct(Cart c) {
		crep.updateProduct(c);
	
	}

	@Override
	public int deleteProduct(Cart c) {
		// TODO Auto-generated method stub
		return crep.deleteProduct(c);
	}

	@Override
	public int addCart(Cart c) {
		// TODO Auto-generated method stub
		return crep.addCart(c);
	}

}
