package com.service;

import java.util.List;

import com.dto.Product;

public interface ProductRepository {
	Product getAllProduct();
	List<String> getProductByCategory(String category);
	Product getProductById(int id);
	int updateProduct(int id);
	int deleteProduct(int id);
	int addProduct(Product p);
	
}
