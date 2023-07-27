package com.narvee.usit.service;

import java.util.List;

import com.narvee.usit.model.User;

public interface UserService   {

	
	
	public void addUser(User user);
	public void deleteUser(Integer UserId);
	public List<User> getAllUsers();
	public void updateUser(User user);
	public User getByUserId(Integer UserId);

	
}
