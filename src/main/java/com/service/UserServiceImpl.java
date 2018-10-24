package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.User;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository urep;
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		urep.addUser(user);
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		urep.updateUser(u);
		return 0;
	}

	@Override
	public User getUserByUName(String uname) {
		
		return urep.getUserByUName(uname);
	}

}
