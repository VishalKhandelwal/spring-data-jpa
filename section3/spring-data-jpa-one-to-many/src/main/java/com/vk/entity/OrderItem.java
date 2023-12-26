package com.vk.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="order_items",schema = "localhost")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name="quantity")
    private int quantity;
}