package com.vk.service;

import java.util.List;

import com.vk.entity.User;

public interface UserService {

	public User saveUser(User user);
	public List<User> fetchUsers();
	public User fetchUser(Long id);
	public void deleteUsers();
}
