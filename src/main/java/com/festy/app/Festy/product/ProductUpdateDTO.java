package com.festy.app.Festy.product;

import com.festy.app.Festy.category.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductUpdateDTO {
    private Long id;
    private String name;
    private Float price;
    private Category category;


}
