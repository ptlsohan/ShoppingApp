package com.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Order;
import com.dto.User;
import com.exception.DBException;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired SessionFactory sf;
	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderByUserId(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Order> o = session.createQuery("from Order").getResultList();
		tx.commit();
		session.close();
		return o;
	}

	@Override
	public int updateOrder(Order o) {
		// TODO Auto-generated method stub
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
	public int addOrder(Order o) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id= (int) session.save(o);
		
		tx.commit();
		session.close();
		return id;
	}

}
