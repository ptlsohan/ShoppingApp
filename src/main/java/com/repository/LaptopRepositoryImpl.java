package com.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Laptop;
import com.dto.Product;

@Repository
public class LaptopRepositoryImpl implements LaptopRepository {

	@Autowired SessionFactory sf;
	
	@Override
	public List<Laptop> getAllLaptop() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Laptop> products = session.createQuery("from Laptop").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	public List<Laptop> getLaptopByCategory(String category) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Laptop> products = session.createQuery("from Laptop where category='"+category+"'").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	public List<Laptop> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Laptop> cr = cb.createQuery(Laptop.class);
		Root<Laptop> root = cr.from(Laptop.class);
		cr.where(cb.like(root.get("name"),"%"+key+"%"));
		
		Query query = session.createQuery(cr);
		List<Laptop> results = query.getResultList();
		System.out.println("product search"+results);
		return results;
	}

	@Override
	public Laptop getLaptopById(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Laptop p=session.get(Laptop.class, id);
		tx.commit();
		session.close();
		return p;
	}

	@Override
	public int updateLaptop(Laptop l) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Laptop l) {
		// TODO Auto-generated method stub
		return 0;
	}

}
