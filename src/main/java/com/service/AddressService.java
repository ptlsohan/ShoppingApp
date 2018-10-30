package com.service;

import java.util.List;

import com.dto.Address;

public interface AddressService {
	Address getAddresstById(int id);
	int updateAddress(Address a);
	void deleteAddress(Address a);
	int addAddress(Address a);
	void addOrUpdate(Address a);
}
