package com.repository;

import java.util.List;

import com.dto.Cart;
import com.dto.Product;
import com.dto.User;

public interface CartRepository {
	List<Product> getAllProduct();
	List<String> getProductByCategory(String category);
	User getProductById(int id);
	int updateProduct(Cart c);
	int deleteProduct(Cart c);
	int addCart(Cart c);
	void updateQty(int id,int qty);
}
