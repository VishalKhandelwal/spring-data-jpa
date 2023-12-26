package com.vk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.entity.Order;
import com.vk.exceptions.ResourceNotFoundException;
import com.vk.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderRepository orderRepository;

	@Override
	public Order saveOrderOperation(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Order fetchOrderOperation(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order with give id is not found on server !! : "+id));
	}

	@Override
	public Order updateOrderOperation(Long id, Order order) {
		// TODO Auto-generated method stub
		Order order1 = orderRepository.findById(id).get();

        //System.out.println(order1.toString());

        order1.setStatus(order.getStatus());

		return orderRepository.save(order1);
	}

	@Override
	public void deleteOrderOperation(Long id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}

}
