package com.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Cart;
import com.dto.Product;
import com.dto.User;

@Repository
public class CartImpl implements CartRepository {

	@Autowired SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Product> products = session.createQuery("from Cart").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	public List<String> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getProductById(int id) {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User u = session.get(User.class, id);
		tx.commit();
		session.close();
		return u;
	}

	@Override
	public int updateProduct(Cart c) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int deleteProduct(Cart c) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
		session.close();
		return 0;
		
	}

	@Override
	public int addCart(Cart c) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id=(int) session.save(c);
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public void updateQty(int id, int qty) {
		// TODO Auto-generated method stub
		
	}

}
