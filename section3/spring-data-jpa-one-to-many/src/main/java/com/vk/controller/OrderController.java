package com.vk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.entity.Order;
import com.vk.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private Logger Logger = LoggerFactory.getLogger(OrderController.class);
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		Order saveOrder = orderService.saveOrderOperation(order);
		Logger.info("createOrder method called................");
		return ResponseEntity.status(HttpStatus.CREATED).body(saveOrder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id){
		 
		return ResponseEntity.ok(orderService.fetchOrderOperation(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order,@PathVariable Long id){
		Order updateOrderOperation = orderService.updateOrderOperation(id, order);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateOrderOperation);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deleteOrder(@RequestParam(value = "id",required = true) Long id){
		 orderService.deleteOrderOperation(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
