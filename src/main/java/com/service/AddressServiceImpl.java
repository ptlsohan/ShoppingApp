package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Address;
import com.repository.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository addrep;
	@Override
	public Address getAddresstById(int id) {
		// TODO Auto-generated method stub
		return addrep.getAddresstById(id);
	}

	@Override
	public void updateAddress(Address a) {
		addrep.updateAddress(a);
		
	}

	@Override
	public void deleteAddress(Address a) {
		addrep.deleteAddress(a);
		
	}

	@Override
	public int addAddress(Address a) {
		
		return addrep.addAddress(a);
	}

	@Override
	public void addOrUpdate(Address a) {
		addrep.addOrUpdate(a);
		
	}

}
