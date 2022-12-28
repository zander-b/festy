package com.festy.app.Festy.order;

import com.festy.app.Festy.product.Product;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class OrderItem {
    @Id
    private Long id;

    private int quantity;

    @OneToOne
    private Product product;
}
