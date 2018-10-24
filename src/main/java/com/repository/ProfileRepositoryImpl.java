package com.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Address;
import com.dto.User;
import com.dto.UserProfile;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

	@Autowired 
	SessionFactory sf;
	
	@Override
	public List<UserProfile> getAllUserProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile getUserByUName(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUserProfile(UserProfile userProfile) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userProfile);
		
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int deleteProfile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProfile(UserProfile p) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql="update UserProfile set age="+ p.getAge()+",firstName='"+ p.getFirstName()+"', lastName='"+p.getLastName()+"' where profileId="+p.getProfileId();
		Query q=session.createNativeQuery(sql);
		q.executeUpdate();
		tx.commit();
		session.close();
	
	}

	@Override
	public UserProfile getProfileById(int uid) {
		Session session = sf.openSession();
		System.out.println("user id"+uid);
		Transaction tx = session.beginTransaction();
		String sql="from UserProfile where user_userId="+uid;
		UserProfile user= (UserProfile) session.createQuery(sql).getSingleResult();
		System.out.println(user.getFirstName());
		tx.commit();
		session.close();
		return user;
	}

}
