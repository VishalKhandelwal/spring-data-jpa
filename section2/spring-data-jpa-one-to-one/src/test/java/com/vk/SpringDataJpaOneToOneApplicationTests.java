package com.vk;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vk.entity.Address;
import com.vk.entity.Order;
import com.vk.repository.OrderRepository;

@SpringBootTest
class SpringDataJpaOneToOneApplicationTests {

	@Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderOperation(){
        // create Order object
        Order order = new Order();

        order.setOrderTrackingNumber("1000");
        order.setStatus("COMPLETED");
        order.setTotalPrice(new BigDecimal(2000));
        order.setTotalQuantity(5);

        Address billingAddress = new Address();
        billingAddress.setStreet("kothrud");
        billingAddress.setCity("pune");
        billingAddress.setState("Maharashra");
        billingAddress.setCountry("India");
        billingAddress.setZipCode("11048");

        order.setBillingAddress(billingAddress);

        // save both order and address ( Cascade type - ALL)
        orderRepository.save(order);
    }

    @Test
    void fetchOrderOperation(){
        // display Order information

        // fetch order with it's address
        Order order1 = orderRepository.findById(1L).get();

        System.out.println(order1.toString());
    }

    @Test
    void updateOrderOperation(){
        // fetch order with it's address
        Order order1 = orderRepository.findById(1L).get();

        System.out.println(order1.toString());

        order1.setStatus("DELIVERED");

        order1.getBillingAddress().setZipCode("11047");

        // update order along with that address
        orderRepository.save(order1);
    }

    @Test
    void deleteOrderOperation(){
        // remove order with it's address
        orderRepository.deleteById(1L);
    }

}
