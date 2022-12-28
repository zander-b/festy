package com.festy.app.Festy.product;

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

    private String fileLocation;

    //todo add categories
}
