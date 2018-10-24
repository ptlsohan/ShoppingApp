package com.repository;

import java.util.List;

import com.dto.Address;
import com.dto.Product;

public interface AddressRepository {
	
	List<Address> getAddresstById(int id);
	int updateAddress(Address a);
	int deleteAddress(int id);
	int addAddress(Address a);
}
