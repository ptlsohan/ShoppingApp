package com.repository;

import java.util.List;

import com.dto.User;

public interface UserRepository {
	List<User> getAllUser();
	User getUserByUName(String uname);
	int addUser(User user);
	int deleteUser(int id);
	int updateUser(User u);
	
}
