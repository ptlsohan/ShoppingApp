package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Address;
import com.repository.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository addrep;
	@Override
	public List<Address> getAddresstById(int id) {
		// TODO Auto-generated method stub
		return addrep.getAddresstById(id);
	}

	@Override
	public int updateAddress(Address a) {
		addrep.updateAddress(a);
		return 0;
	}

	@Override
	public int deleteAddress(int id) {
		addrep.deleteAddress(id);
		return 0;
	}

	@Override
	public int addAddress(Address a) {
		
		return addrep.addAddress(a);
	}

}