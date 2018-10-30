package com.repository;

import java.util.List;

import com.dto.Product;

public interface ProductRepository {
	List<Product> getAllProduct();
	List<Product> getAllProductByPage(int i);
	List<Product> getProductByCategory(String category);
	List<Product> getProductByPage(String category,int s);
	List<Product> searchProduct(String key);
	Product getProductById(int id);
	
	

	int updateProduct(int id);
	int deleteProduct(int id);
	int addProduct(Product p);
	int getQty(int id);
	int updateProduct(int id, int qty);
	List<Product> searchApi(String key);
	
}
