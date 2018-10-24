package com.service;

import java.util.List;

import com.dto.UserProfile;

public interface ProfileService {
	List<UserProfile> getAllUserProfile();
	UserProfile getUserByUName(String uname);
	UserProfile getProfileById(int uid);
	int addUserProfile(UserProfile userProfile);
	int deleteProfile();
	void updateProfile(UserProfile userProfile);
}
