package com.vk.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}