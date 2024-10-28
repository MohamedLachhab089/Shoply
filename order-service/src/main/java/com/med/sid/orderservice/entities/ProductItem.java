package com.med.sid.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.med.sid.orderservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @Transient
    private Product product;
    @Column(nullable = true)
    private double price;
    @Column(nullable = true)
    private int quantity;
    @Column(nullable = true)
    private double discount;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    public double getAmount() {
        return price * quantity * (1 - discount);
    }
}
