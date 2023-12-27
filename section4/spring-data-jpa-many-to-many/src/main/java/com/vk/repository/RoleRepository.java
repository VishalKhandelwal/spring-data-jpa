package com.vk.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}