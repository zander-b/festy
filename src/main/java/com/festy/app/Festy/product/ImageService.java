package com.festy.app.Festy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    public Image save(Image image){
        return repository.save(image);
    }
}
