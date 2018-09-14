package com.doherty.productmicroservice.services;

import com.doherty.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String getNameFromId(Long id) {
        return productRepository.getOne(id).getName();
    }

}
