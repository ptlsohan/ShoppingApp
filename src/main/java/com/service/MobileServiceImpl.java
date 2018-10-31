package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Mobile;
import com.repository.MobileRepository;


@Service
public class MobileServiceImpl implements MobileService{

	@Autowired MobileRepository mrep;
	
	@Override
	public List<Mobile> getAllMobile() {
		
		return mrep.getAllMobile();
	}

	@Override
	public List<Mobile> getMobileByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mobile getMobileById(int id) {
		// TODO Auto-generated method stub
		return mrep.getMobileById(id);
	}

	@Override
	public int updateMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Mobile mobile) {
		// TODO Auto-generated method stub
		return mrep.addProduct(mobile);
	}

	@Override
	public List<Mobile> searchProduct(String key) {
		// TODO Auto-generated method stub
		return mrep.searchProduct(key);
	}

	@Override
	public long getTotalCount() {
		// TODO Auto-generated method stub
		return mrep.getTotalCount();
	}

	

}
