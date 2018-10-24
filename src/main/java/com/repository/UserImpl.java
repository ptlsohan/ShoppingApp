package com.repository;

import java.util.List;
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
	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addUser(User user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id= (int) session.save(user);
		
		tx.commit();
		session.close();
		return id;
	}

	public int deleteUser(int id) {
		
		return 0;
	}

	public int updateUser(User u) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(u);
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public User getUserByUName(String uname) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql="from User where username='"+uname+"'";
		Optional<User> user=  session.createQuery(sql).uniqueResultOptional();
		user.orElse(new User());
	//	System.out.println(user.getUsername());
		tx.commit();
		session.close();
		return user.get();
	}

}
