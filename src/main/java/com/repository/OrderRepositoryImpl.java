package com.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Order;
import com.dto.Product;
import com.exception.DBException;

@Repository
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=DBException.class)
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired SessionFactory sf;
	@Autowired ProductRepository ps;
	
	@Autowired HibernateTemplate template;
	
	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderByUserId(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Order> o = session.createQuery("from Order where user="+id+" order by orderId desc").getResultList();
		tx.commit();
		session.close();
		return o;
	}

	@Override
	public int updateOrder(Order o) throws DBException {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		for(Map.Entry<Product, Integer> entry: o.getProductList().entrySet()) {
			int qty=ps.getQty(entry.getKey().getId());
			if(qty-entry.getValue()<0) {
				throw new DBException("Product not available"+entry.getKey().getName());
			}
			ps.updateProduct(entry.getKey().getId(),qty-entry.getValue());
		}
		
		 session.merge(o);
		
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int deleteOrder(int id) throws DBException {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
		String hql = "delete from Order where orderId="+id;
		  Query query = session.createQuery(hql);
		  query.executeUpdate();
		  tx.commit();
	}finally {
		session.close();
	}
		return 0;
	}

	@Override
	@Transactional
	public int addOrder(Order o) throws DBException {
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
		int id= (int) template.save(o);
		
//		tx.commit();
//		session.close();
		return id;
	}

}
