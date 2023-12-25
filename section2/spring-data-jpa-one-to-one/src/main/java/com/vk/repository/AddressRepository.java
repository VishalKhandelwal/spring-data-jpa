package com.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
