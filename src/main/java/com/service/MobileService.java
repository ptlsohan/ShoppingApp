package com.service;

import java.util.List;

import com.dto.Fashion;
import com.dto.Mobile;


public interface MobileService {
	List<Mobile> getAllMobile();
	List<Mobile> getMobileByCategory(String category);
	List<Mobile> searchProduct(String key);
	Mobile  getMobileById(int id);
	int updateMobile (Mobile  mobile );
	int deleteProduct(int id);
	int addProduct(Mobile mobile );
	
}
