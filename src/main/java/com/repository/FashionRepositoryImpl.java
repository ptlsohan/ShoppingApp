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

import com.dto.Fashion;


@Repository
public class FashionRepositoryImpl implements FashionRepository {

	@Autowired SessionFactory sf;
	
	@Override
	public List<Fashion> getAllFashion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fashion> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fashion> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Fashion> cr = cb.createQuery(Fashion.class);
		Root<Fashion> root = cr.from(Fashion.class);
		cr.where(cb.or(cb.like(root.get("name"),"%"+key+"%"),cb.like(root.get("companyName"),"%"+key+"%")));
		
		
		Query query = session.createQuery(cr);
		List<Fashion> results = query.getResultList();
		tx.commit();
		session.close();
		
		return results;
		
	}

	@Override
	public Fashion getFashionById(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Fashion fashion= session.get(Fashion.class, id);
		tx.commit();
		session.close();
		return fashion;
	}

	@Override
	public int updateFashion(Fashion f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Fashion f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTotalCount() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Fashion> root = cr.from(Fashion.class);
		cr.select(cb.count(root));
		

		Query query = session.createQuery(cr);
		
		Long result = (Long) query.getSingleResult();
		
		
		tx.commit();
		session.close();
		return result;
	}

}
