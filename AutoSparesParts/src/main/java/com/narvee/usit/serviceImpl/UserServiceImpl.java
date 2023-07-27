package com.narvee.usit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvee.usit.model.User;
import com.narvee.usit.repository.UserRepository;
import com.narvee.usit.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public void addUser(User user) {
		userRepo.save(user);
		
		
	}

	@Override
	public void deleteUser(Integer UserId) {
		
		userRepo.deleteById(UserId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
	}

	@Override
	public User getByUserId(Integer UserId) {
		return userRepo.findById(UserId).get();
	}

}
