package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserProfile;
import com.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired ProfileRepository pr;
	
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
		pr.addUserProfile(userProfile);
		return 0;
	}

	@Override
	public int deleteProfile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		pr.updateProfile(userProfile);
	}

	@Override
	public UserProfile getProfileById(int uid) {
		
		return pr.getProfileById(uid);
	}

}
