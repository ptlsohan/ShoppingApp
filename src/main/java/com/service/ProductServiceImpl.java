package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Product;
import com.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired ProductRepository prep;
	
	@Override
	public List<Product> getAllProduct() {
		
		return prep.getAllProduct();
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		
		return prep.getProductByCategory(category);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return prep.getProductById(id);
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		prep.updateProduct(p);;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> searchProduct(String key) {
		
		return prep.searchProduct(key);
	}

	@Override
	public List<Product> getProductByPage(String category, int s) {
		// TODO Auto-generated method stub
		return prep.getProductByPage(category, s);
	}

	@Override
	public List<Product> getAllProductByPage(int i) {
		// TODO Auto-generated method stub
		return prep.getAllProductByPage(i);
	}

	@Override
	public int getQty(int id) {
		// TODO Auto-generated method stub
		return prep.getQty(id);
	}

	@Override
	public List<Product> searchApi(String key) {
		// TODO Auto-generated method stub
		return prep.searchApi(key);
	}

	@Override
	public long getTotalCount() {
		// TODO Auto-generated method stub
		return prep.getTotalCount();
	}

}
