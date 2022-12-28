package com.festy.app.Festy.product;

import com.festy.app.Festy.category.Category;
import com.festy.app.Festy.util.ImageUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Base64;

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
    @ManyToOne
    private Image image;

    //todo add categories

    public String getRawImage(){
        return Base64.getEncoder().encodeToString(ImageUtils.decompressImage(image.getImage()));
    }
}
