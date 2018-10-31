package com.service;

import java.util.List;

import com.dto.Product;

public interface ProductService {
	List<Product> getAllProduct();
	List<Product> getProductByCategory(String category);
	List<Product> getAllProductByPage(int i);
	List<Product> searchProduct(String key);
	List<Product> getProductByPage(String category,int s);
	Product getProductById(int id);
	void updateProduct(Product p);
	int deleteProduct(int id);
	int addProduct(Product p);
	int getQty(int id);
	List<Product> searchApi(String key);
	long getTotalCount();
}
