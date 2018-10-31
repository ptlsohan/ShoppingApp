package com.repository;

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
	public Address getAddresstById(int id) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Address address=session.get(Address.class, id);
		tx.commit();
		session.close();
		return address;
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
	public void deleteAddress(Address a) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(a);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public int addAddress(Address a) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id=(int) session.save(a);
		
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public void addOrUpdate(Address a) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(a);
		
		tx.commit();
		session.close();
		
	}

}
