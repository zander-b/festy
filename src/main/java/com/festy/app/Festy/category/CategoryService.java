package com.festy.app.Festy.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public void addCategory(Category category){
        repository.save(category);
    }

    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    public void deleteCategory(Long id){
        repository.deleteById(id);
    }
}
