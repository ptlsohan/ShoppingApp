package com.repository;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.User;

@Repository
public class UserImpl implements UserRepository {

	@Autowired 
	SessionFactory sf;
	
	

	public int addUser(User user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id= (int) session.save(user);
		
		tx.commit();
		session.close();
		return id;
	}

	public void deleteUser(User user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		 session.delete(user);
		 tx.commit();
		session.close();
	
	}

	public void updateUser(User u) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUName(String uname) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql="from User where username='"+uname+"'";
		Optional<User> user=  session.createQuery(sql).uniqueResultOptional();
		user.orElse(new User());
		tx.commit();
		session.close();
		return user.get();
	}

}
