package com.service;

import java.util.List;

import com.dto.Fashion;
import com.dto.Product;

public interface FashionService {
	List<Fashion> getAllFashion();
	List<Fashion> getProductByCategory(String category);
	List<Fashion> searchProduct(String key);
	Fashion  getFashionById(int id);
	int updateFashion (Fashion  f );
	int deleteProduct(int id);
	int addProduct(Fashion  f );
}
