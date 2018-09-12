package com.doherty.ordermicroservice.repository;

import com.doherty.ordermicroservice.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Long> {
}
