package com.doherty.productmicroservice.repository;

import com.doherty.productmicroservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
