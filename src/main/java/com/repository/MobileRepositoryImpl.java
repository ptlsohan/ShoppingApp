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

import com.dto.Mobile;

@Repository
public class MobileRepositoryImpl implements MobileRepository{

	@Autowired SessionFactory sf;
	
	@Override
	public List<Mobile> getAllMobile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mobile> getMobileByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mobile getMobileById(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Mobile mobile = session.get(Mobile.class, id);
		tx.commit();
		session.close();
		return mobile;
	}

	@Override
	public int updateMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Mobile mobile) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id= (int) session.save(mobile);
		
		tx.commit();
		session.close();
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mobile> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Mobile> cr = cb.createQuery(Mobile.class);
		Root<Mobile> root = cr.from(Mobile.class);
		cr.where(cb.or(cb.like(root.get("name"),"%"+key+"%"),cb.like(root.get("companyName"),"%"+key+"%")));
		
		
		Query query = session.createQuery(cr);
		List<Mobile> results = query.getResultList();
		System.out.println("search result"+results);
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public long getTotalCount() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Mobile> root = cr.from(Mobile.class);
		cr.select(cb.count(root));
		

		Query query = session.createQuery(cr);
		
		Long result = (Long) query.getSingleResult();
		
		
		tx.commit();
		session.close();
		return result;
	}

	

}
