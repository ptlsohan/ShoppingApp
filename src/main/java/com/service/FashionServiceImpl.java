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
		return null;
	}

	@Override
	public List<Fashion> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fashion getFashionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFashion(Fashion f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Fashion f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Fashion> searchProduct(String key) {
		// TODO Auto-generated method stub
		return frep.searchProduct(key);
	}

}
