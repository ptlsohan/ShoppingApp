package com.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Mobile;
import com.dto.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	
	
	@Autowired SessionFactory sf;

	

	@Override
	public List<Product> getAllProduct() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Product> products = session.createQuery("from Product").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Product> products = session.createQuery("from Product where category='"+category+"'").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	public Product getProductById(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Product p=session.get(Product.class, id);
		tx.commit();
		session.close();
		return p;
	}

	@Override
	public int updateProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
		Root<Product> root = cr.from(Product.class);
		cr.where(cb.like(root.get("name"),"%"+key+"%"));
		
		Query query = session.createQuery(cr);
		List<Product> results = query.getResultList();
		System.out.println("product search"+results);
		return results;
	}

	@Override
	public List<Product> getProductByPage(String category, int s) {
		 s=s*5;
		Session session = sf.openSession();
		Query query=session.createQuery("from Product where category='"+category+"'");
		
		query.setFirstResult(s); 
		query.setMaxResults(5);
		List<Product> list=query.getResultList();
		System.out.println(list);
		session.close();
		return list;
	}

	@Override
	public List<Product> getAllProductByPage(int i) {
		 i=i*5;
			Session session = sf.openSession();
			Query query=session.createQuery("from Product");
			
			query.setFirstResult(i); 
			query.setMaxResults(5);
			List<Product> list=query.getResultList();
			System.out.println(list);
			session.close();
			return list;
	}

	

}
