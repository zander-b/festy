package com.festy.app.Festy.product;

import com.festy.app.Festy.category.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private Float price;

    @ManyToOne
    private Category category;
    private String fileLocation;
}
