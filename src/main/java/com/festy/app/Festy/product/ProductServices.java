package com.festy.app.Festy.product;

import com.festy.app.Festy.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    public void addProduct(Product product){
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
