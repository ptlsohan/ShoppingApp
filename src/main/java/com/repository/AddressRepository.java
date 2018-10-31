package com.repository;

import com.dto.Address;

public interface AddressRepository {
	
	Address getAddresstById(int id);
	int updateAddress(Address a);
	void deleteAddress(Address a);
	int addAddress(Address a);
	
	void addOrUpdate(Address a);
}
