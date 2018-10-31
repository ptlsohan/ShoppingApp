package com.repository;

import com.dto.User;

public interface UserRepository {

	User getUserByUName(String uname);
	int addUser(User user);
	void deleteUser(User u);
	void updateUser(User u);
	
}
