package com.repository;

import java.util.List;

import com.dto.Address;
import com.dto.Product;

public interface AddressRepository {
	
	Address getAddresstById(int id);
	int updateAddress(Address a);
	void deleteAddress(Address a);
	int addAddress(Address a);
	
	void addOrUpdate(Address a);
}
