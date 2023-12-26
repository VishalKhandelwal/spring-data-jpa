package com.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	Order findByOrderTrackingNumber(String orderTrackingNumber);
}
