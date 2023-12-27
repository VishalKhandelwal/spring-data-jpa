package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.entity.User;
import com.vk.exceptions.ResourceNotFoundException;
import com.vk.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> fetchUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User fetchUser(Long id) {
		// TODO Auto-generated method stub
		//return userRepository.findById(id).get();
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not found with given id"+id));
	}

	@Override
	public void deleteUsers() {
		userRepository.deleteAll();

	}

}
