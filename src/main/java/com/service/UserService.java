package com.service;

import java.util.List;

import com.dto.User;


public interface UserService {
	List<User> getAllUser();
	User getUserByUName(String uname);
	int addUser(User user);
	int deleteUser(int id);
	int updateUser(User u);
}

