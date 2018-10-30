package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	List<User> usr(int id);

}
