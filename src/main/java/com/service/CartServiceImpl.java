package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Cart;
import com.dto.Product;
import com.dto.User;
import com.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired CartRepository crep;
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getProductById(int id) {
		// TODO Auto-generated method stub
		return crep.getProductById(id);
	}

	@Override
	public int updateProduct(Cart c) {
		crep.updateProduct(c);
		return 0;
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
