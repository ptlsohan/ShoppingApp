package com.service;

import java.util.List;

import com.dto.Laptop;

public interface LaptopService {
	List<Laptop> getAllLaptop();
	List<Laptop> getLaptopByCategory(String category);
	List<Laptop> searchProduct(String key);
	Laptop  getLaptopById(int id);
	int updateLaptop (Laptop l);
	int deleteProduct(int id);
	int addProduct(Laptop l);
	
	
}
