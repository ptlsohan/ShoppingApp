package com.service;

import java.util.List;

import com.dto.Address;

public interface AddressService {
	List<Address> getAddresstById(int id);
	int updateAddress(Address a);
	int deleteAddress(int id);
	int addAddress(Address a);
}
