package com.service;

import com.dto.Address;

public interface AddressService {
	Address getAddresstById(int id);
	void updateAddress(Address a);
	void deleteAddress(Address a);
	int addAddress(Address a);
	void addOrUpdate(Address a);
}
