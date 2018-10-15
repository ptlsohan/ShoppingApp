package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Product;

public class ProductRepositoryImpl implements ProductRepository {
	
	public Product getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public int updateProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
