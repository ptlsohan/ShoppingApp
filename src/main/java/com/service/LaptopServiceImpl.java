package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Laptop;
import com.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired LaptopRepository lrep;
	@Override
	public List<Laptop> getAllLaptop() {
		
		return lrep.getAllLaptop();
	}

	@Override
	public List<Laptop> getLaptopByCategory(String category) {
		// TODO Auto-generated method stub
		return lrep.getLaptopByCategory(category);
	}

	@Override
	public List<Laptop> searchProduct(String key) {
		// TODO Auto-generated method stub
		return lrep.searchProduct(key);
	}

	@Override
	public Laptop getLaptopById(int id) {
		// TODO Auto-generated method stub
		return lrep.getLaptopById(id);
	}

	@Override
	public int updateLaptop(Laptop l) {
		// TODO Auto-generated method stub
		return lrep.updateLaptop(l);
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return lrep.deleteProduct(id);
	}

	@Override
	public int addProduct(Laptop l) {
		// TODO Auto-generated method stub
		return lrep.addProduct(l);
	}

}
