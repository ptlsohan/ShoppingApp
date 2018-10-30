package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Fashion;
import com.dto.Product;
import com.repository.FashionRepository;


@Service
public class FashionServiceImpl implements FashionService {

	@Autowired FashionRepository frep;
	@Override
	public List<Fashion> getAllFashion() {
		// TODO Auto-generated method stub
		return frep.getAllFashion();
	}

	@Override
	public List<Fashion> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return frep.getProductByCategory(category);
	}

	@Override
	public Fashion getFashionById(int id) {
		// TODO Auto-generated method stub
		return frep.getFashionById(id);
	}

	@Override
	public int updateFashion(Fashion f) {
		// TODO Auto-generated method stub
		return frep.updateFashion(f);
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return frep.deleteProduct(id);
	}

	@Override
	public int addProduct(Fashion f) {
		// TODO Auto-generated method stub
		return frep.addProduct(f);
	}

	@Override
	public List<Fashion> searchProduct(String key) {
		// TODO Auto-generated method stub
		return frep.searchProduct(key);
	}

}
