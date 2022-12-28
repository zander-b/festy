package com.festy.app.Festy.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Product {
    @Id
    private Long id;

    private String name;

    private Float price;

    private String fileLocation;

    //todo add categories
}
