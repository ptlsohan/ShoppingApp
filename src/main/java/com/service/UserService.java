package com.service;

import com.repository.UserRepository;

public interface UserService {
	UserRepository getAllUser();
	int addUser();
	int deleteUser();
	int updateUser();
}
