package com.java.springboot.service;


import java.util.List;

import com.java.springboot.model.User;

public interface UserService {
	
	User findById(String id);
	
	User findByEmail(String email);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(String id);

	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);
	
}
