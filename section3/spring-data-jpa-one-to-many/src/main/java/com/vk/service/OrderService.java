package com.vk.service;

import com.vk.entity.Order;

public interface OrderService {

	public Order saveOrderOperation(Order order);
	public Order fetchOrderOperation(Long id);
	public Order updateOrderOperation(Long id,Order order);
	public void deleteOrderOperation(Long id);
}
