package com.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Address;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

	@Autowired 
	SessionFactory sf;
	
	@Override
	public List<Address> getAddresstById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAddress(Address a) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(a);
		
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int deleteAddress(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addAddress(Address a) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(a);
		
		tx.commit();
		session.close();
		return 0;
	}

}
