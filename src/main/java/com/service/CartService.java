package com.service;

import com.dto.Cart;
import com.dto.User;


public interface CartService {

	User getProductById(int id);
	void updateProduct(Cart c);
	int deleteProduct(Cart c);
	int addCart(Cart c);
}
