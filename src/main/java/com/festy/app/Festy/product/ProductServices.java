package com.festy.app.Festy.product;

import com.festy.app.Festy.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ImageService imageService;

    public void addProduct(Product product){
        repository.save(product);
    }

    public void addProductWithImage(Product product, MultipartFile file){
        Image image = imageService.save(ImageUtils.buildEntity(file));
        product.setImage(image);
        repository.save(product);
    }

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public Product getProductById(long id){
        Optional< Product > optional = repository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" product not found for id :: " + id);
        }
        return product;
    }

    public void deleteProduct(Long id){
        repository.deleteById(id);
    }
}
